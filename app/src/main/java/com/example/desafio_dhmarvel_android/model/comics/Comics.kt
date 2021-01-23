package com.example.desafio_dhmarvel_android.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comics(
    var attributionHTML: String?,
    var attributionText: String?,
    var code: String?,
    var copyright: String?,
    var data: Data?,
    var etag: String?,
    var status: String?
):Parcelable