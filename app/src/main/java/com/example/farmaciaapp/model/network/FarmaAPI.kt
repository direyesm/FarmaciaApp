package com.example.farmaciaapp.model.network

import com.example.farmaciaapp.model.pojo.Farmacia
import retrofit2.Response
import retrofit2.http.GET

interface FarmaAPI {

    @GET("getLocales")
    suspend fun fecthAllFarmacias(): Response<List<Farmacia>>
}