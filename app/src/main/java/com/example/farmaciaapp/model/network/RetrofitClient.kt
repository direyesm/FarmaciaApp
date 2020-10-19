package com.example.farmaciaapp.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{


        private const val URL_BASE = "https://farmanet.minsal.cl/index.php/ws/"


        fun getRetrofifCliente() : FarmaAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(FarmaAPI::class.java)
        }
    }
}