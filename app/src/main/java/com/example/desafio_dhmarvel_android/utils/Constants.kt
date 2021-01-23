package com.example.desafio_dhmarvel_android.utils

class Constants {

    object Api {
        const val BASE_URL = "https://gateway.marvel.com/v1/public/"
        const val PUBLIC_KEY = "PUBLIC KEY"
        const val PRIVATE_KEY = "PRIVATE KEY"
        const val QUERY_PARAM_TS = "ts"
        const val QUERY_PARAM_HASH_LABEL = "hash"
        const val QUERY_APIKEY = "apikey"
    }

    object ConstantsHqs {
        const val BASE_HQ_KEY = "HQ"
        const val BASE_HQIMAGE_KEY = "HQIMAGE"}

    object Paging {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}