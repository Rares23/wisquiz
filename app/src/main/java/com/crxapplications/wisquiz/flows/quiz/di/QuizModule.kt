package com.crxapplications.wisquiz.flows.quiz.di

import android.content.res.AssetManager
import com.crxapplications.wisquiz.flows.quiz.data.provider.CategoryAssetDataProvider
import com.crxapplications.wisquiz.flows.quiz.data.provider.CategoryAssetDataProviderImpl
import com.crxapplications.wisquiz.flows.quiz.data.provider.QuizApiService
import com.crxapplications.wisquiz.flows.quiz.data.repository.CategoryRepositoryImpl
import com.crxapplications.wisquiz.flows.quiz.domain.repository.CategoryRepository
import com.crxapplications.wisquiz.flows.quiz.domain.use_case.GetCategoriesUseCase
import com.crxapplications.wisquiz.flows.quiz.domain.use_case.GetCategoriesUseCaseImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class QuizModule {
    @Singleton
    @Provides
    fun provideCategoryAssetDataProvider(
        moshi: Moshi,
        assetManager: AssetManager,
    ): CategoryAssetDataProvider = CategoryAssetDataProviderImpl(
        moshi = moshi,
        assetManager = assetManager,
    )

    @Singleton
    @Provides
    fun provideCategoryRepository(
        categoryAssetDataProvider: CategoryAssetDataProvider,
    ): CategoryRepository = CategoryRepositoryImpl(
        categoryAssetDataProvider = categoryAssetDataProvider,
    )

    @Singleton
    @Provides
    fun provideGetCategoriesUseCase(categoryRepository: CategoryRepository): GetCategoriesUseCase =
        GetCategoriesUseCaseImpl(
            categoryRepository = categoryRepository
        )

    @Singleton
    @Provides
    fun provideQuizApiService(retrofit: Retrofit) = retrofit.create(QuizApiService::class.java)
}