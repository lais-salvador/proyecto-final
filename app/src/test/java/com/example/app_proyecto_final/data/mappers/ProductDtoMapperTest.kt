package com.example.app_proyecto_final.data.mappers

import com.example.app_proyecto_final.utils.ProductDtoTestDataBuilder
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ProductDtoMapperTest {
    @Test
    fun `WHEN toProductModel with values EXPECT model has value`(){
        val productDto = ProductDtoTestDataBuilder().withId(1).buildSingle()

        val result = productDto.toProductModel()

        assertThat(result.id, `is` ("1"))
    }

    @Test
    fun `WHEN toProductModel with null values EXPECT empty string`(){
        val productDto = ProductDtoTestDataBuilder().buildSingle()

        val result = productDto.toProductModel()

        assertThat(result.id, `is`(""))
    }

    @Test
    fun `WHEN toProductModel with invalid format price value EXPECT productModel with valid price`(){
        val productDto = ProductDtoTestDataBuilder()
            .withPrice(2.2)
            .buildSingle()

        val result = productDto.toProductModel()

        assertThat(result.price, `is`("2,20€"))
    }

    @Test
    fun `WHEN toProductLocal with values EXPECT model has value`(){
        val productDto = ProductDtoTestDataBuilder().withId(1).buildSingle()

        val result = productDto.toProductLocal()

        assertThat(result.id, `is` ("1"))
    }

    @Test
    fun `WHEN toProductLocal with null values EXPECT empty string`(){
        val productDto = ProductDtoTestDataBuilder().buildSingle()

        val result = productDto.toProductLocal()

        assertThat(result.id, `is`(""))
    }

    @Test
    fun `WHEN toProductLocal with invalid format price value EXPECT productModel with valid price`(){
        val productDto = ProductDtoTestDataBuilder()
            .withPrice(2.2)
            .buildSingle()

        val result = productDto.toProductLocal()

        assertThat(result.price, `is`("2,20€"))
    }

}