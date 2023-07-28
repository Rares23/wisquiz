package com.crxapplications.wisquiz.flows.quiz.domain.repository

import com.crxapplications.wisquiz.flows.quiz.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<List<Category>>
}