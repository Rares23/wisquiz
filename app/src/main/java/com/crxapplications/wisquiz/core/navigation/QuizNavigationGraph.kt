package com.crxapplications.wisquiz.core.navigation

import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizEndPage
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizRunningPage
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizStartPage

fun NavGraphBuilder.quizNavigationGraph(navController: NavController) {
    navigation(
        route = Route.Quiz.route,
        startDestination = Route.QuizStart.route,
        arguments = Route.Quiz.arguments
    ) {
        composable(route = Route.QuizStart.route) { backStackEntry ->
            val parentEntry =
                remember(backStackEntry) { navController.getBackStackEntry(Route.Quiz.route) }
            val categoryId = parentEntry.arguments?.getInt("categoryId") ?: -1

            QuizStartPage(categoryId = categoryId)
        }

        composable(route = Route.QuizRunning.route) {
            QuizRunningPage()
        }

        composable(route = Route.QuizEnd.route) {
            QuizEndPage()
        }
    }
}