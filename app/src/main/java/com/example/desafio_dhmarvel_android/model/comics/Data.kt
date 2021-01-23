package com.example.desafio_dhmarvel_android.model

data class Data(
    var count: String?,
    var limit: String?,
    var offset: String?,
    var results: List<Result>?,
    var total: String?
)