package com.protel.medskin.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse (
    val id: String,
    val title: String,
    val description: String,
    val imgPath: String
):Parcelable