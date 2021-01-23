package com.example.desafio_dhmarvel_android.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Creators(
    var available: String?,
    var collectionURI: String?,
    var items: List<Item>?,
    var returned: String?
): Parcelable