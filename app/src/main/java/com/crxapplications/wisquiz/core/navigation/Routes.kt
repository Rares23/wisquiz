package com.crxapplications.wisquiz.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Route(val route: String, val arguments: List<NamedNavArgument> = emptyList()) {
    object Root : Route(route = "root")
    object Home : Route(route = "home")
    object Quizzes : Route(route = "quizzes")
    object Progress : Route(route = "progress")
    object Quiz : Route(
        route = "quiz/{categoryId}",
        arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
    )

    object QuizStart : Route(route = "quiz-start")

    object QuizRunning : Route(route = "quiz-running")
    object QuizEnd : Route(route = "quiz-end")
    object Settings : Route(route = "settings")
}