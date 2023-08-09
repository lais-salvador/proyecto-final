package com.example.app_proyecto_final.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.app_proyecto_final.testutil.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ProductApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()

    private lateinit var api: ProductApi

    @Before
    fun setup() {
        api = retrofit.create(ProductApi::class.java)
    }

    @Test
    fun `WHEN request product list EXPECT result`() = runTest {
        val result = api.getProductList()

        assertThat(result.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request product by id EXPECT product`() = runTest {
        val result = api.getProductById("1")

        assertThat(result.id, `is`(1))
    }

    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                // lo ideal es probar contra un entorno estable
                // entorno de QA
                .baseUrl("https://fakestoreapi.com")
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}