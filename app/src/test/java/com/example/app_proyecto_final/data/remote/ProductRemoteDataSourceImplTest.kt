package com.example.app_proyecto_final.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.app_proyecto_final.data.ProductApi
import com.example.app_proyecto_final.testutil.DefaultDispatcherRule
import com.example.app_proyecto_final.utils.ProductDtoTestDataBuilder
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductRemoteDataSourceImplTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var productApi: ProductApi

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN api response of getProductList is a list with products EXPECT return list`()= runTest{
        coEvery {
            productApi.getProductList()
        } returns ProductDtoTestDataBuilder()
            .withId(1)
            .withNumElements(2)
            .buildList()
        val remoteRepository = RemoteDataSourceImpl(productApi)

        val result = remoteRepository.getProductList()

        assert(result.isNotEmpty())
        assert(result.size == 2)
    }

    @Test
    fun `WHEN api response of getProductList failed EXPECT return empty list`() = runTest{
        val remoteRepository = RemoteDataSourceImpl(productApi)

        val result = remoteRepository.getProductList()

        assert(result.isEmpty())
    }

    @Test
    fun `WHEN api response of getProduct by id is a product EXPECT return product`()= runTest{
        coEvery {
            productApi.getProductById("1")
        } returns ProductDtoTestDataBuilder()
            .withId(1)
            .buildSingle()
        val remoteRepository = RemoteDataSourceImpl(productApi)

        val result = remoteRepository.getProductById("1")

        assert(result.id == 1)
    }
}