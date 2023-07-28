package com.crxapplications.wisquiz.flows.quiz.domain.use_case

import com.crxapplications.wisquiz.flows.quiz.domain.model.Category
import com.crxapplications.wisquiz.flows.quiz.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

interface GetCategoriesUseCase {
    suspend operator fun invoke(): Flow<List<Category>>
}

class GetCategoriesUseCaseImpl constructor(
    private val categoryRepository: CategoryRepository,
) : GetCategoriesUseCase {
    override suspend operator fun invoke() =
        categoryRepository.getCategories()
}