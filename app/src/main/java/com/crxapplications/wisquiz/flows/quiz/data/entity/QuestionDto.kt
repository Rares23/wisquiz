package com.crxapplications.wisquiz.flows.quiz.data.entity

import com.squareup.moshi.Json

data class QuestionDto(
    @field:Json(name = "type") val type: String,
    @field:Json(name = "difficulty") val difficulty: String,
    @field:Json(name = "question") val question: String,
    @field:Json(name = "correct_answer") val correctAnswer: String,
    @field:Json(name = "incorrect_answer") val incorrectAnswer: List<String>,
)