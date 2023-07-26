package com.crxapplications.wisquiz.core.navigation

sealed class Route(val route: String) {
    object Quizzes : Route(route = "quizzes")
    object Progress : Route(route = "progress")
}