package com.protel.medskin.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse (
    val id: String,
    val title: String,
    val penyebab: String,
    val gejala: String,
    val cara: String,
    val imgPath: String
):Parcelable