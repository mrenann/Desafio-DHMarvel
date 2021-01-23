package com.example.desafio_dhmarvel_android.model.comics

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CollectedIssue(
    var name: String?,
    var resourceURI: String?
):Parcelable