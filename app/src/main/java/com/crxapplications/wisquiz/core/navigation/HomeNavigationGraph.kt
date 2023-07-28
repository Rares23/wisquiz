package com.crxapplications.wisquiz.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizzesListPage
import com.crxapplications.wisquiz.flows.stats.presentation.page.StatsPage

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Route.Home.route,
        startDestination = Route.Quizzes.route
    ) {
        composable(route = Route.Quizzes.route) {
            QuizzesListPage()
        }

        composable(route = Route.Progress.route) {
            StatsPage()
        }
    }
}