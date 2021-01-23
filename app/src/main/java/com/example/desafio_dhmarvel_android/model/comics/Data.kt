package com.example.desafio_dhmarvel_android.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    var count: String?,
    var limit: String?,
    var offset: String?,
    var results: List<Result>?,
    var total: String?
):Parcelable