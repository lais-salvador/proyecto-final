package com.example.app_proyecto_final.data

import com.example.app_proyecto_final.data.local.LocalDataSource
import com.example.app_proyecto_final.data.mappers.toProductLocal
import com.example.app_proyecto_final.data.mappers.toProductModel
import com.example.app_proyecto_final.data.remote.RemoteDataSource
import com.example.app_proyecto_final.domain.model.ProductModel

class ProductRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): ProductRepository {
    override suspend fun getProductList(): List<ProductModel> {
        val localData = localDataSource.getProductList()

        return if (localData.isNotEmpty()){
            localData.map { it.toProductModel() }
        }else{
            val remoteData = remoteDataSource.getProductList()
            if(remoteData.isNotEmpty())
                localDataSource.insertProductList(remoteData.map { it.toProductLocal() })
            remoteData.map { it.toProductModel() }
        }
    }

    override suspend fun getProductById(id: String): ProductModel {
        return localDataSource.getProductById(id).toProductModel()
    }

    override suspend fun updateFavoriteStateOfProduct(
        isFavorite: Boolean,
        productId: String
    ): Boolean = localDataSource.updateFavoriteStateOfProduct(isFavorite, productId)

    override suspend fun getFavoriteList(): List<ProductModel> = localDataSource.getFavoriteList().map { it.toProductModel() }

}