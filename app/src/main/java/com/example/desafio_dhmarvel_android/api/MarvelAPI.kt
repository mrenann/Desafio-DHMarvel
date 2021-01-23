package com.example.desafio_dhmarvel_android.api

import com.example.desafio_dhmarvel_android.model.comics.Comics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    @GET("comics")
    suspend fun getComics(
            @Query("characters") characters: Int = 1009610,
            @Query("formatType") formatType: String = "comic",
            @Query("noVariants") noVariants: String = "true",
            //@Query("format") format: String = "comic",
            @Query("limit") limit: Int = 100
    ): Response<Comics>

}
