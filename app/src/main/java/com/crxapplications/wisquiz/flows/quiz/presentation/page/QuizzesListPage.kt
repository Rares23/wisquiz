package com.crxapplications.wisquiz.flows.quiz.presentation.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.crxapplications.wisquiz.R
import com.crxapplications.wisquiz.core.helper.toString
import com.crxapplications.wisquiz.flows.quiz.presentation.view.QuizCategoryCard
import com.crxapplications.wisquiz.flows.quiz.presentation.view_model.QuizzesViewModel
import com.crxapplications.wisquiz.flows.quiz.presentation.view_model.state.QuizzesState

@Composable
fun QuizzesListPage(
    quizzesViewModel: QuizzesViewModel = hiltViewModel(),
    onCategoryPress: (Int) -> Unit,
) {
    val uiState by quizzesViewModel.uiState.collectAsState()

    when (uiState) {
        is QuizzesState.DataLoadedState -> {
            val categories = (uiState as QuizzesState.DataLoadedState).categories
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(),
                contentPadding = PaddingValues(bottom = 8.dp),
            ) {
                items(count = categories.size) { index ->
                    val category = categories[index]
                    QuizCategoryCard(
                        modifier = Modifier.padding(
                            vertical = 8.dp,
                            horizontal = 16.dp,
                        ),
                        category = category
                    ) {
                        onCategoryPress(category.id)
                    }
                }
            }
        }

        QuizzesState.LoadingState -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is QuizzesState.ErrorState -> {
            Column {
                Icon(
                    Icons.Rounded.Warning,
                    contentDescription = stringResource(id = R.string.error_icon_cd)
                )
                Text(text = (uiState as QuizzesState.ErrorState).errorMessage.toString(LocalContext.current))
            }
        }
    }


}