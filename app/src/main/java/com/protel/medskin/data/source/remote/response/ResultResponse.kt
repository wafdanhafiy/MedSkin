package com.protel.medskin.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class ResultResponse(
    @field:SerializedName("prediction")
    val predictionResult: Int? = null,
)