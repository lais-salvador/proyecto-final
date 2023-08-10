package com.example.app_proyecto_final.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.app_proyecto_final.data.local.model.ProductLocal

@Dao
interface ProductDao {
    @Query("SELECT * FROM ProductTable")
    suspend fun getAll(): List<ProductLocal>

    @Query("SELECT * FROM ProductTable WHERE id=:id")
    suspend fun getProductById(id: String) : ProductLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<ProductLocal>)

    @Query("UPDATE ProductTable SET favorite=:isFavorite WHERE id=:productId")
    suspend fun updateProduct(isFavorite: Boolean, productId: String);

    @Query("SELECT * FROM ProductTable WHERE favorite=1")
    suspend fun getFavoriteList(): List<ProductLocal>
}