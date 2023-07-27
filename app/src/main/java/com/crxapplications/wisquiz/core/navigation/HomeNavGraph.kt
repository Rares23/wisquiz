package com.crxapplications.wisquiz.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizzesListPage
import com.crxapplications.wisquiz.flows.stats.presentation.page.StatsPage

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.Quizzes.route) {
        composable(Route.Quizzes.route) {
            QuizzesListPage()
        }

        composable(Route.Progress.route) {
            StatsPage()
        }
    }
}