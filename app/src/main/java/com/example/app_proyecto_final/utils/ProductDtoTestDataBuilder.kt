package com.example.app_proyecto_final.utils

import com.example.app_proyecto_final.data.remote.dto.ProductDto
import com.example.app_proyecto_final.data.remote.dto.RatingDto
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.domain.model.RatingModel

class ProductDtoTestDataBuilder {
    var id = 0
    var title = ""
    var description = ""
    var price = 0.0
    var category  = ""
    var image = ""
    var rating = RatingDto(0.0,0)
    var numElements: Int = 1



    fun withId(id: Int): ProductDtoTestDataBuilder {
        this.id = id
        return this
    }

    fun withTitle(title: String): ProductDtoTestDataBuilder {
        this.title = title
        return this
    }

    fun withDescription(description: String): ProductDtoTestDataBuilder {
        this.description = description
        return this
    }

    fun withPrice(price: Double): ProductDtoTestDataBuilder {
        this.price = price
        return this
    }

    fun withCategory(category: String): ProductDtoTestDataBuilder {
        this.category = category
        return this
    }

    fun withNumElements(numElements: Int): ProductDtoTestDataBuilder {
        this.numElements = numElements
        return this
    }

    fun buildList(): List<ProductDto> {
        val list = mutableListOf<ProductDto>()

        for(i in 0 until numElements) {
            list.add(
                ProductDto(
                    id = id,
                    title = title,
                    description = description,
                    category = category,
                    price = price,
                    image = image,
                    rating = rating
                )
            )
        }
        return list.toList()
    }

    fun buildSingle(): ProductDto {
        return ProductDto(
            id = id,
            title = title,
            description = description,
            category = category,
            price = price,
            image = image,
            rating = rating
        )
    }
}