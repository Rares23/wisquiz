package com.crxapplications.wisquiz.flows.quiz.presentation.view_model.state

import com.crxapplications.wisquiz.core.helper.UiText
import com.crxapplications.wisquiz.flows.quiz.domain.model.Category

sealed class QuizzesState {
    object LoadingState : QuizzesState()
    data class ErrorState(
        val errorMessage: UiText,
    ) : QuizzesState()

    data class DataLoadedState(
        val categories: List<Category>,
    ) : QuizzesState()
}