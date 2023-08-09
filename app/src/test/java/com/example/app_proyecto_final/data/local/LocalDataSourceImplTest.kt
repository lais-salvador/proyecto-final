package com.example.app_proyecto_final.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.app_proyecto_final.testutil.DefaultDispatcherRule
import com.example.app_proyecto_final.utils.ProductLocalTestDataBuilder
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LocalDataSourceImplTest{
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var productDao: ProductDao

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }


    @Test
    fun `WHEN getProductList return productListLocal EXPECT list`() = runTest {
        coEvery { productDao.getAll() } returns ProductLocalTestDataBuilder()
            .withId("1")
            .withNumElements(2)
            .buildList()
        val localRepository = LocalDataSourceImpl(productDao)

        val result = localRepository.getProductList()

        assert(result.size == 2)
    }

    @Test
    fun `WHEN getProductList failed EXPECT empty list`() = runTest {
        val localRepository = LocalDataSourceImpl(productDao)

        val result = localRepository.getProductList()

        assert(result.isEmpty())
    }

    @Test
    fun `WHEN getProductById return product EXPECT product`() = runTest {
        coEvery { productDao.getProductById("1") } returns ProductLocalTestDataBuilder()
            .withId("1")
            .buildSingle()
        val localRepository = LocalDataSourceImpl(productDao)

        val result = localRepository.getProductById("1")

        assert(result.id == "1")
    }

    @Test
    fun `WHEN getProductById product EXPECT empty product`() = runTest {
        val localRepository = LocalDataSourceImpl(productDao)

        val result = localRepository.getProductById("")

        assert(result.id == "")
    }
}