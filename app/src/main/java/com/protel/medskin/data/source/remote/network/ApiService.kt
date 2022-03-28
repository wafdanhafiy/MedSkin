package com.protel.medskin.data.source.remote.network

import com.protel.medskin.BuildConfig
import com.protel.medskin.data.source.remote.response.ResponseMaps
import com.protel.medskin.data.source.remote.response.ResultResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("place/nearbysearch/json")
    fun getHospitalNearBye(
        @Query("location") location: String,
        @Query("radius") radius: String = "2000",
        @Query("types") types: String = "hospital",
        @Query("key") key: String = BuildConfig.MAPS_TOKEN,
    ): Call<ResponseMaps>

    @Multipart
    @POST("/")
    fun getPrediction(
        @PartMap map: HashMap<String, RequestBody>
    ): Call<ResultResponse>
}