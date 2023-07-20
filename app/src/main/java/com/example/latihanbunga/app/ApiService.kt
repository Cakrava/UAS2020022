package com.example.latihanbunga.app


import com.example.latihanbunga.model.BungaModel
import com.example.latihanbunga.model.ResponseKue
import com.example.latihanbunga.model.ResponseModel
import com.example.latihanbunga.model.ResponseSekolah
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("tblBunga/save")
    fun saveBunga(
        @Body data: BungaModel
    ): Call<ResponseModel>

    @GET("bunga")
    fun getBunga(): Call<ResponseModel>

    @GET("sekolah")
    fun getSekolah(): Call<ResponseSekolah>

    @GET("kue")
    fun getKue(): Call<ResponseKue>
}
