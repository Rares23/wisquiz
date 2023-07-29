package com.crxapplications.wisquiz.flows.quiz.domain.use_case

interface GetQuizUseCase {
    suspend operator fun invoke()
}

class GetQuizUseCaseImpl : GetQuizUseCase {
    override suspend fun invoke() {

    }
}