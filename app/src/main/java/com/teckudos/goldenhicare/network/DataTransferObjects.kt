package com.teckudos.goldenhicare.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryData(
    val id: String,
    val name: String,
    @Json(name = "img_src") val imgSrcUrl: String,
    val description: String
) : Parcelable {

}

