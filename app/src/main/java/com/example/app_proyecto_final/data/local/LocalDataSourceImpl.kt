package com.example.app_proyecto_final.data.local

import com.example.app_proyecto_final.data.local.model.ProductLocal

class LocalDataSourceImpl(
    private val productDao: ProductDao
): LocalDataSource {
    override suspend fun insertProductList(productList: List<ProductLocal>) = productDao.insertAll(productList)
    override suspend fun getProductList(): List<ProductLocal> = productDao.getAll()
    override suspend fun getProductById(id: String): ProductLocal = productDao.getProductById(id)
}