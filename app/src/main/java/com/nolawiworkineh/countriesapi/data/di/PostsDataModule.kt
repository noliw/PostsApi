package com.nolawiworkineh.countriesapi.data.di

import com.nolawiworkineh.countriesapi.data.network.NetworkClient
import com.nolawiworkineh.countriesapi.data.network.PostsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostsDataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = NetworkClient.retrofit

    @Provides
    @Singleton
    fun providePostsApiService(retrofit: Retrofit): PostsApiService {
        return retrofit.create(PostsApiService::class.java)
    }


}