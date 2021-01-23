package com.example.desafio_dhmarvel_android.model

data class Events(
    var available: String?,
    var collectionURI: String?,
    var items: List<Item>?,
    var returned: String?
)