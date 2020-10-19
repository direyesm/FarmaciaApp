package com.example.farmaciaapp.model.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Farma_table")
class FarmaciaEntity (@PrimaryKey @NonNull
                      val id: String,
                      val Nombre: String?,
                      val Comuna: String?,
                      val Direccion: String?
)