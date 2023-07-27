package com.crxapplications.wisquiz.flows.quiz.presentation.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.crxapplications.wisquiz.flows.quiz.presentation.view.QuizCategoryCard

@Composable
fun QuizzesListPage() {
    Column {
        QuizCategoryCard(modifier = Modifier.padding(16.dp))
    }
}