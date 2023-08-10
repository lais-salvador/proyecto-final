package com.example.app_proyecto_final.data.mappers

import com.example.app_proyecto_final.utils.ProductLocalTestDataBuilder
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ProductLocalMapperTest{
    @Test
    fun`WHEN toProductModel with values EXPECT model has values`(){
        val productLocal = ProductLocalTestDataBuilder().withId("an id").buildSingle()

        val result = productLocal.toProductModel()

        assertThat(result.id, `is`("an id"))
    }
}