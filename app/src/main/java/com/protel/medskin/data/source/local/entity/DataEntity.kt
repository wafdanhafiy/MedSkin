package com.protel.medskin.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "tb_data")
@Parcelize
data class DataEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "penyebab")
    val penyebab: String,

    @ColumnInfo(name = "gejala")
    val gejala: String,

    @ColumnInfo(name = "cara")
    val cara: String,

    @ColumnInfo(name = "imgPath")
    val imgPath: String
) : Parcelable