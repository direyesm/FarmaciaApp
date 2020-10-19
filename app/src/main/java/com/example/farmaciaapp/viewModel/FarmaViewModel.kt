package com.example.farmaciaapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.farmaciaapp.model.FarmaRepository
import com.example.farmaciaapp.model.local.FarmaDatabase
import com.example.farmaciaapp.model.local.FarmaciaEntity

class FarmaViewModel(application: Application): AndroidViewModel(application) {

    private val mRepository : FarmaRepository
    val liveDataFromLocal : LiveData<List<FarmaciaEntity>>

    init {
        val farmaDao = FarmaDatabase.getDatabase(application).FarmaDao()
        mRepository = FarmaRepository(farmaDao)
        mRepository.getDataFromServer()
        liveDataFromLocal = mRepository.allFarmaLiveData
    }

    fun getFarmaByID( id : String): LiveData<FarmaciaEntity>{
        return mRepository.getFarmaByID(id)
    }
}