package com.example.app_proyecto_final.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.app_proyecto_final.domain.usecase.GetProductByIdUseCase
import com.example.app_proyecto_final.testutil.DefaultDispatcherRule
import com.example.app_proyecto_final.utils.ProductModelTestDataBuilder
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getProductByIdUseCase: GetProductByIdUseCase


    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN GetProductListUseCase return a ProductList EXPECT Idle, Loading, ProductList states`() = runTest {
        val product = ProductModelTestDataBuilder()
            .withId("1")
            .buildSingle()

        coEvery { getProductByIdUseCase.invoke("1") } returns product

        val detailViewModel = DetailViewModel(getProductByIdUseCase)

        detailViewModel.productFlow.test{
            detailViewModel.getProductData("1")

            assertEquals(DetailState.Idle, awaitItem())
            assertEquals(DetailState.Loading, awaitItem())
            assertEquals(DetailState.Product(product), awaitItem())
        }
    }

    @Test
    fun `WHEN GetProductListUseCase return a emptyList EXPECT Idle, Loading, Error state`() = runTest {
        val product = ProductModelTestDataBuilder().buildSingle()

        coEvery { getProductByIdUseCase.invoke("") } returns product

        val detailViewModel = DetailViewModel(getProductByIdUseCase)

        detailViewModel.productFlow.test{
            detailViewModel.getProductData("")

            assertEquals(DetailState.Idle, awaitItem())
            assertEquals(DetailState.Loading, awaitItem())
            assertEquals(DetailState.Error, awaitItem())
        }
    }
}