package com.example.app_proyecto_final.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app_proyecto_final.data.local.model.ProductLocal

@Database([ProductLocal::class], version = 2, exportSchema = false)
abstract class ProductDataBase: RoomDatabase() {
    abstract fun productLocalDao(): ProductDao
}