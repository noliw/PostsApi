package com.nolawiworkineh.countriesapi.data.di

import com.nolawiworkineh.countriesapi.data.PostsRepositoryImpl
import com.nolawiworkineh.countriesapi.data.network.NetworkClient
import com.nolawiworkineh.countriesapi.data.network.PostsApiService
import com.nolawiworkineh.countriesapi.domain.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostsDataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = NetworkClient.retrofit

    @Provides
    @Singleton
    fun providePostsApiService(retrofit: Retrofit): PostsApiService =
        retrofit.create(PostsApiService::class.java)


    @Provides
    @Singleton
    fun provideRepositoryImplementation(postsApiService: PostsApiService): PostsRepository =
        PostsRepositoryImpl(postsApiService)


}