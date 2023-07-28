package com.crxapplications.wisquiz.flows.quiz.data.repository

import com.crxapplications.wisquiz.flows.quiz.data.entity.toCategory
import com.crxapplications.wisquiz.flows.quiz.data.provider.CategoryAssetDataProvider
import com.crxapplications.wisquiz.flows.quiz.domain.model.Category
import com.crxapplications.wisquiz.flows.quiz.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepositoryImpl constructor(
    private val categoryAssetDataProvider: CategoryAssetDataProvider,
) : CategoryRepository {

    override suspend fun getCategories(): Flow<List<Category>> =
        categoryAssetDataProvider.loadCategories().map { data ->
            data.map { it.toCategory() }.toList()
        }
}