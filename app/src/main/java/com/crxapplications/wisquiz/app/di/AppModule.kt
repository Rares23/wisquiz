package com.crxapplications.wisquiz.app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.AssetManager
import com.crxapplications.wisquiz.core.data.api.TokenApiService
import com.crxapplications.wisquiz.core.data.repository.TokenRepository
import com.crxapplications.wisquiz.core.data.repository.TokenRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            "com.crxapplications.wisquiz",
            Context.MODE_PRIVATE
        )


    @Singleton
    @Provides
    fun provideMoshiBuilder(): Moshi =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun provideTriviaOpenApiRetrofit(
        moshi: Moshi,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://opentdb.com/api.php")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Singleton
    @Provides
    fun provideAssetManager(application: Application): AssetManager = application.assets

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://opentdb.com/api.php")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Singleton
    @Provides
    fun provideTokenApiService(retrofit: Retrofit): TokenApiService =
        retrofit.create(TokenApiService::class.java)


    @Singleton
    @Provides
    fun provideTokenRepository(
        tokenApiService: TokenApiService,
        sharedPreferences: SharedPreferences,
    ): TokenRepository = TokenRepositoryImpl(
        tokenApiService = tokenApiService,
        sharedPreferences = sharedPreferences
    )
}