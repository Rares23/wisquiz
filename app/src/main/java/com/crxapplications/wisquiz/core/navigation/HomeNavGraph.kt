package com.crxapplications.wisquiz.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.Quizzes.route) {
        composable(Route.Quizzes.route) {
            Text(text = "Quizzes")
        }

        composable(Route.Progress.route) {
            Text(text = "Progress")
        }
    }
}