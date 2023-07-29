package com.crxapplications.wisquiz.flows.quiz.data.entity

import com.squareup.moshi.Json

data class QuizResponseDto(
    @field:Json(name = "response_code") val responseCode: Int,
    @field:Json(name = "results") val questions: List<QuestionDto>,
)