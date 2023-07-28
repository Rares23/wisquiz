package com.crxapplications.wisquiz.flows.quiz.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crxapplications.wisquiz.flows.quiz.domain.use_case.GetCategoriesUseCase
import com.crxapplications.wisquiz.flows.quiz.presentation.view_model.state.QuizzesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizzesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<QuizzesState>(QuizzesState.LoadingState)

    val uiState: StateFlow<QuizzesState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getCategoriesUseCase().collect { data ->
                _uiState.emit(
                    QuizzesState.DataLoadedState(
                        data
                    )
                )
            }
        }
    }
}