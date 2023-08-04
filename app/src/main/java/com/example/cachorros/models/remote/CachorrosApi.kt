package com.example.cachorros.models.remote

import com.example.cachorros.models.remote.classApi.CachorrosClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CachorrosApi {
    @GET("breed/{id}/images/random")
    suspend fun fechCachorros(@Path("id")id:String): Response<List<CachorrosClass>>

    @GET("breed/{id}/images")
    suspend fun fechRaza(@Path("id")id:String): Response<List<CachorrosClass>>
}