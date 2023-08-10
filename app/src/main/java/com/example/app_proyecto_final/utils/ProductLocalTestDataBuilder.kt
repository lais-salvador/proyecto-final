package com.example.app_proyecto_final.utils

import com.example.app_proyecto_final.data.local.model.ProductLocal

class ProductLocalTestDataBuilder {
    var id = ""
    var title = ""
    var description = ""
    var price = ""
    var category  = ""
    var image = ""
    var numElements: Int = 1
    var favorite = false

    fun withId(id: String): ProductLocalTestDataBuilder {
        this.id = id
        return this
    }

    fun withTitle(title: String): ProductLocalTestDataBuilder {
        this.title = title
        return this
    }

    fun withDescription(description: String): ProductLocalTestDataBuilder {
        this.description = description
        return this
    }

    fun withPrice(price: String): ProductLocalTestDataBuilder {
        this.price = price
        return this
    }

    fun withCategory(category: String): ProductLocalTestDataBuilder {
        this.category = category
        return this
    }

    fun withNumElements(numElements: Int): ProductLocalTestDataBuilder {
        this.numElements = numElements
        return this
    }

    fun withFavorite(favorite: Boolean): ProductLocalTestDataBuilder {
        this.favorite = favorite
        return this
    }

    fun buildList(): List<ProductLocal> {
        val list = mutableListOf<ProductLocal>()

        for(i in 0 until numElements) {
            list.add(
                ProductLocal(
                    id = id,
                    title = title,
                    description = description,
                    category = category,
                    price = price,
                    image = image,
                    favorite = favorite
                )
            )
        }
        return list.toList()
    }

    fun buildSingle(): ProductLocal {
        return ProductLocal(
            id = id,
            title = title,
            description = description,
            category = category,
            price = price,
            image = image,
            favorite = favorite
        )
    }
}