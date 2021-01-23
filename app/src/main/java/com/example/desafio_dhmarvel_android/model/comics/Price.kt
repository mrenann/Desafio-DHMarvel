package com.example.desafio_dhmarvel_android.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    var price: String?,
    var type: String?
) : Parcelable