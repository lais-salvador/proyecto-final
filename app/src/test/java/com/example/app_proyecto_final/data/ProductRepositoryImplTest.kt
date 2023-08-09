package com.example.app_proyecto_final.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.app_proyecto_final.data.local.LocalDataSource
import com.example.app_proyecto_final.data.local.model.ProductLocal
import com.example.app_proyecto_final.data.remote.RemoteDataSource
import com.example.app_proyecto_final.data.remote.dto.ProductDto
import com.example.app_proyecto_final.testutil.DefaultDispatcherRule
import com.example.app_proyecto_final.utils.ProductDtoTestDataBuilder
import com.example.app_proyecto_final.utils.ProductLocalTestDataBuilder
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductRepositoryImplTest{
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource


    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getProductList EXPECT local data`() = runTest {
        coEvery {
            localDataSource.getProductList()
        } returns ProductLocalTestDataBuilder()
            .withId("1")
            .withNumElements(2)
            .buildList()
        coEvery { remoteDataSource.getProductList() } returns listOf<ProductDto>()

        val remoteRepository = ProductRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val result = remoteRepository.getProductList()

        assert(result.size == 2)
    }

    @Test
    fun `WHEN getProductList EXPECT remote data`() = runTest {
        coEvery { localDataSource.getProductList() } returns listOf<ProductLocal>()
        coEvery {
            remoteDataSource.getProductList()
        } returns ProductDtoTestDataBuilder()
            .withId(1)
            .withNumElements(2)
            .buildList()

        val remoteRepository = ProductRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val result = remoteRepository.getProductList()

        assert(result.size == 2)
    }

    @Test
    fun `WHEN getProductById EXPECT local data`() = runTest {
        coEvery {
            localDataSource.getProductById("1")
        } returns ProductLocalTestDataBuilder()
            .withId("1")
            .buildSingle()

        val remoteRepository = ProductRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val result = remoteRepository.getProductById("1")

        assert(result.id == "1")
    }
}