package com.example.desafio_dhmarvel_android.api

import com.example.desafio_dhmarvel_android.utils.Constants.Api.BASE_URL
import com.example.desafio_dhmarvel_android.utils.Constants.Api.PRIVATE_KEY
import com.example.desafio_dhmarvel_android.utils.Constants.Api.PUBLIC_KEY
import com.example.desafio_dhmarvel_android.utils.Constants.Api.QUERY_APIKEY
import com.example.desafio_dhmarvel_android.utils.Constants.Api.QUERY_PARAM_HASH_LABEL
import com.example.desafio_dhmarvel_android.utils.Constants.Api.QUERY_PARAM_TS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit

object APIService {

    val MARVEL_API: MarvelAPI = getMarvelApiClient().create(MarvelAPI::class.java)

    private fun getMarvelApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .build()
                chain.proceed(newRequest)
            }
            .addInterceptor { chain ->
                val TS_VALUE = System.currentTimeMillis().toString()
                val url = chain.request().url().newBuilder()
                        .addQueryParameter(QUERY_APIKEY, PUBLIC_KEY)
                        .addQueryParameter(QUERY_PARAM_HASH_LABEL, (TS_VALUE + PRIVATE_KEY + PUBLIC_KEY).md5())
                        .addQueryParameter(QUERY_PARAM_TS, TS_VALUE)
                    .build()
                val newRequest = chain.request().newBuilder().url(url).build()
                chain.proceed(newRequest)
            }
        return interceptor.build()
    }

    fun String.md5():String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }


}