package com.example.app_proyecto_final.presentation.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.domain.usecase.GetProductListUseCase
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

class ListViewModelTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getProductListUseCase: GetProductListUseCase


    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN GetProductListUseCase return a ProductList EXPECT Idle, Loading, ProductList states`() = runTest {
        val productList = ProductModelTestDataBuilder()
            .withNumElements(15)
            .buildList()

        coEvery { getProductListUseCase.invoke() } returns productList

        val listViewModel = ListViewModel(getProductListUseCase)

        listViewModel.productListFlow.test{
            listViewModel.getData()

            assertEquals(ListState.Idle, awaitItem())
            assertEquals(ListState.Loading, awaitItem())
            assertEquals(ListState.ProductList(productList), awaitItem())
        }
    }

    @Test
    fun `WHEN GetProductListUseCase return a emptyList EXPECT Idle, Loading, Error state`() = runTest {
        val productList = emptyList<ProductModel>()

        coEvery { getProductListUseCase.invoke() } returns productList

        val listViewModel = ListViewModel(getProductListUseCase)

        listViewModel.productListFlow.test{
            listViewModel.getData()

            assertEquals(ListState.Idle, awaitItem())
            assertEquals(ListState.Loading, awaitItem())
            assertEquals(ListState.Error, awaitItem())
        }
    }
}