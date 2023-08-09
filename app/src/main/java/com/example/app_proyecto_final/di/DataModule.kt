package com.example.app_proyecto_final.di

import android.content.Context
import androidx.room.Room
import com.example.app_proyecto_final.data.ProductApi
import com.example.app_proyecto_final.data.ProductRepository
import com.example.app_proyecto_final.data.ProductRepositoryImpl
import com.example.app_proyecto_final.data.local.LocalDataSource
import com.example.app_proyecto_final.data.local.LocalDataSourceImpl
import com.example.app_proyecto_final.data.local.ProductDao
import com.example.app_proyecto_final.data.local.ProductDataBase
import com.example.app_proyecto_final.data.remote.RemoteDataSource
import com.example.app_proyecto_final.data.remote.RemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val DataModule = module{
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<ProductRepository> {ProductRepositoryImpl(get(), get())}

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<ProductApi> {
        getProductApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesProductDao(get())
    }

}

private fun getProductApi(retrofit: Retrofit) =
    retrofit.create(ProductApi::class.java)

private fun getDatabase(context: Context) : ProductDataBase =
    Room.databaseBuilder(
        context,
        ProductDataBase::class.java, "product-db"
    ).build()

private fun providesProductDao(db: ProductDataBase) : ProductDao =
    db.productLocalDao()