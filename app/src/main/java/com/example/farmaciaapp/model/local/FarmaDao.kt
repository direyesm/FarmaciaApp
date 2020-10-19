package com.example.farmaciaapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FarmaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFarma(mList: List<FarmaciaEntity>)

    @Query("SELECT * FROM farma_table")
    fun showAllFarma(): LiveData<List<FarmaciaEntity>>

    @Query("SELECT * FROM farma_table WHERE id =:mId")
    fun showOnFarmaByID(mId : String): LiveData<FarmaciaEntity>
}