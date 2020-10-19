package com.example.farmaciaapp.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.farmaciaapp.model.local.FarmaDao
import com.example.farmaciaapp.model.local.FarmaciaEntity
import com.example.farmaciaapp.model.network.RetrofitClient
import com.example.farmaciaapp.model.pojo.Farmacia
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FarmaRepository(private val farmaDao: FarmaDao) {

    private val retroService = RetrofitClient.getRetrofifCliente()
    val allFarmaLiveData = farmaDao.showAllFarma()

    fun getFarmaByID(id : String): LiveData<FarmaciaEntity>{
        return farmaDao.showOnFarmaByID(id)
    }


    fun getDataFromServer() = CoroutineScope(Dispatchers.IO).launch {
        val service = kotlin.runCatching { retroService.fecthAllFarmacias() }
        service.onSuccess {
            when(it.code()){
                in 200..299 -> it.body()?.let {
                    farmaDao.insertAllFarma(convert(it))
                }
                in 300..599 -> Log.d("RESPONSE_300", it.body().toString())
                else -> Log.d("ERROR", it.errorBody().toString())
            }
        }
        service.onFailure {
            Log.e("ERROR", it.message.toString())
        }
    }

    fun convert(listFarma: List<Farmacia>): List<FarmaciaEntity>{
        var far : MutableList<FarmaciaEntity> = mutableListOf<FarmaciaEntity>()
        listFarma.map {
            far.add(
                FarmaciaEntity(it.localId,
            it.localNombre,
            it.comunaNombre,
            it.localDireccion))
        }
        return far
    }
}