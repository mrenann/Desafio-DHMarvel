package com.example.desafio_dhmarvel_android.model.comics

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Result(
        var characters: Characters?,
    //var collectedIssues: List<CollectedIssue>?,
    //var collections: List<Collection>?,
        var creators: Creators?,
        var dates: @RawValue List<Date>?,
        var description: String?,
        var diamondCode: String?,
        var digitalId: String?,
        var ean: String?,
        var events: Events?,
        var format: String?,
        var id: String?,
        var images: @RawValue List<Image>?,
        var isbn: String?,
        var issn: String?,
        var issueNumber: String?,
        var modified: String?,
        var pageCount: @RawValue String?,
        var prices: @RawValue List<Price>?,
        var resourceURI: String?,
        var series: Series?,
        var stories: Stories?,
        var textObjects: @RawValue List<TextObject>?,
        var thumbnail: Thumbnail?,
        var title: String?,
        var upc: String?,
        var urls: @RawValue List<Url>?,
        var variantDescription: String?,
        var variants: @RawValue List<Variant>?
): Parcelable {

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<Result> = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}