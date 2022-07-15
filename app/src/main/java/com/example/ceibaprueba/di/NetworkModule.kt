package com.example.ceibaprueba.di

import com.example.ceibaprueba.data.network.PostApiClient
import com.example.ceibaprueba.data.network.UserApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiUser(retrofit: Retrofit):UserApiClient{
        return retrofit.create(UserApiClient::class.java)
    }
    @Singleton
    @Provides
    fun provideApiPost(retrofit: Retrofit): PostApiClient {
        return retrofit.create(PostApiClient::class.java)
    }

}