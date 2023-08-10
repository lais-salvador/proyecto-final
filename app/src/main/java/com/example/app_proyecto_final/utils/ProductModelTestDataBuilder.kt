package com.example.app_proyecto_final.utils

import com.example.app_proyecto_final.domain.model.ProductModel

class ProductModelTestDataBuilder {
    private var id = ""
    private var title = ""
    private var description = ""
    private var price = ""
    private var category  = ""
    private var image = ""
    private var numElements: Int = 1



    fun withId(id: String): ProductModelTestDataBuilder {
        this.id = id
        return this
    }

    fun withTitle(title: String): ProductModelTestDataBuilder {
        this.title = title
        return this
    }

    fun withDescription(description: String): ProductModelTestDataBuilder {
        this.description = description
        return this
    }

    fun withPrice(price: String): ProductModelTestDataBuilder {
        this.price = price
        return this
    }

    fun withCategory(category: String): ProductModelTestDataBuilder {
        this.category = category
        return this
    }

    fun withNumElements(numElements: Int): ProductModelTestDataBuilder {
        this.numElements = numElements
        return this
    }

    fun buildList(): List<ProductModel> {
        val list = mutableListOf<ProductModel>()

        for(i in 0 until numElements) {
            list.add(
                ProductModel(
                    id = id,
                    title = title,
                    description = description,
                    category = category,
                    price = price,
                    image = image,
                    favorite = false
                )
            )
        }
        return list.toList()
    }

    fun buildSingle(): ProductModel {
        return ProductModel(
            id = id,
            title = title,
            description = description,
            category = category,
            price = price,
            image = image,
            favorite = false
        )
    }
}