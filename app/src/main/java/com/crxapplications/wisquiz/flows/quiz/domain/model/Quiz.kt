package com.crxapplications.wisquiz.flows.quiz.domain.model

data class Quiz(
    val categoryId: Int,
    val questions: List<Question>,
)