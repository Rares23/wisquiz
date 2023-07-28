package com.crxapplications.wisquiz.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.crxapplications.wisquiz.flows.quiz.presentation.page.QuizzesListPage
import com.crxapplications.wisquiz.flows.stats.presentation.page.StatsPage

fun NavGraphBuilder.homeNavGraph(
    rootNavController: NavHostController,
) {
    composable(route = Route.Quizzes.route) {
        QuizzesListPage(onCategoryPress = { id ->
            //TODO pass id to quiz route
            rootNavController.navigate(route = Route.Quiz.route)
        })
    }

    composable(route = Route.Progress.route) {
        StatsPage()
    }
}