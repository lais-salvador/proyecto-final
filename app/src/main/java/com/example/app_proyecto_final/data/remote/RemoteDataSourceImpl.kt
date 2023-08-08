package com.example.app_proyecto_final.data.remote

import com.example.app_proyecto_final.data.ProductApi
import com.example.app_proyecto_final.data.remote.dto.ProductDto
import com.example.app_proyecto_final.utils.ProductDtoTestDataBuilder

class RemoteDataSourceImpl(
    private val productApi: ProductApi
): RemoteDataSource {
    override suspend fun getProductList(): List<ProductDto> {
        var productList = emptyList<ProductDto>()

        try{
            productList =  productApi.getProductList()
        }catch (t: Throwable){}

        return  productList
    }
    override suspend fun getProductById(id: String): ProductDto {
        var product = ProductDtoTestDataBuilder().buildSingle()

        try{
            product = productApi.getProductById(id)
        }catch (t: Throwable){}

        return product
    }
}