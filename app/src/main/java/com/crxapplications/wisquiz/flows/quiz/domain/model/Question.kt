package com.crxapplications.wisquiz.flows.quiz.domain.model

data class Question(
    val text: String,
    val type: QuestionType,
)

enum class QuestionType {
    BOOLEAN, MULTIPLE;

    companion object {
        fun fromTypeString(type: String): QuestionType = when (type) {
            "boolean" -> BOOLEAN
            else -> MULTIPLE
        }
    }
}