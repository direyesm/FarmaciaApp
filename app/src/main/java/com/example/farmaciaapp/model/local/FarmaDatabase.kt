package com.example.farmaciaapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FarmaciaEntity::class], version = 1)
abstract class FarmaDatabase : RoomDatabase(){

    abstract  fun FarmaDao(): FarmaDao

    companion object{
        @Volatile
        private var INSTANCE : FarmaDatabase? = null

        fun getDatabase(context: Context): FarmaDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,
                        FarmaDatabase::class.java,
                        "FarmaDb")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}