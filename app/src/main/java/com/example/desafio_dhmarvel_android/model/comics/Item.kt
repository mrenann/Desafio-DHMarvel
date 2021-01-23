package com.example.desafio_dhmarvel_android.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    var name: String?,
    var resourceURI: String?,
    var role: String?,
    var type: String?
): Parcelable