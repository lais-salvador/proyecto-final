package com.example.app_proyecto_final.data.local

import com.example.app_proyecto_final.data.local.model.ProductLocal
import com.example.app_proyecto_final.utils.ProductLocalTestDataBuilder

class LocalDataSourceImpl(
    private val productDao: ProductDao
): LocalDataSource {
    override suspend fun insertProductList(productList: List<ProductLocal>) = productDao.insertAll(productList)
    override suspend fun getProductList(): List<ProductLocal> {
        var productList = emptyList<ProductLocal>()

        try{
            productList = productDao.getAll()
        }catch (t: Throwable){ }

        return productList
    }
    override suspend fun getProductById(id: String): ProductLocal {
        var product = ProductLocalTestDataBuilder().buildSingle()

        try{
            product = productDao.getProductById(id)
        }catch(t: Throwable){ }

        return product
    }

    override suspend fun updateFavoriteStateOfProduct(
        isFavorite: Boolean,
        productId: String
    ): Boolean {
        var success = false

        try{
            productDao.updateProduct(isFavorite, productId)
            success = true
        }catch (t: Throwable){ }

        return success
    }

    override suspend fun getFavoriteList(): List<ProductLocal> {
        var productList = emptyList<ProductLocal>()

        try{
            productList = productDao.getFavoriteList()
        }catch (t: Throwable){ }

        return productList
    }

}