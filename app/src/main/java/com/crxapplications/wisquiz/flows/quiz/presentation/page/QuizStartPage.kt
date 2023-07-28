package com.crxapplications.wisquiz.flows.quiz.presentation.page

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun QuizStartPage(categoryId: Int) {
    Text(text = "Build quiz for category id -> $categoryId")
}