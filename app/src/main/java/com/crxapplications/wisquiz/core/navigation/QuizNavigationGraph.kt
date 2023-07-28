package com.crxapplications.wisquiz.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizEndPage
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizRunningPage
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizStartPage

fun NavGraphBuilder.quizNavigationGraph(navController: NavController) {
    navigation(route = Route.Quiz.route, startDestination = Route.QuizStart.route) {
        composable(route = Route.QuizStart.route) {
            QuizStartPage()
        }

        composable(route = Route.QuizRunning.route) {
            QuizRunningPage()
        }

        composable(route = Route.QuizEnd.route) {
            QuizEndPage()
        }
    }
}