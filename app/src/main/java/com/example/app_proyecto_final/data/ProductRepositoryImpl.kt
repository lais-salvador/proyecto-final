package com.example.app_proyecto_final.data

import com.example.app_proyecto_final.data.local.LocalDataSource
import com.example.app_proyecto_final.data.mappers.toProductModel
import com.example.app_proyecto_final.data.remote.RemoteDataSource
import com.example.app_proyecto_final.domain.model.ProductModel

class ProductRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): ProductRepository {
    override suspend fun getProductList(): List<ProductModel> {
        var productList = remoteDataSource.getProductList()

        return if(productList.isNotEmpty())
            productList.map { it.toProductModel() }
        else emptyList()
    }

    override suspend fun getProductById(id: String): ProductModel {
        return remoteDataSource.getProductById(id).toProductModel()
    }
}