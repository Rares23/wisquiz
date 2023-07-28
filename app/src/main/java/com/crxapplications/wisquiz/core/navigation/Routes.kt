package com.crxapplications.wisquiz.core.navigation

sealed class Route(val route: String) {
    object Root: Route(route = "root")
    object Home: Route(route = "home")
    object Quizzes : Route(route = "quizzes")
    object Progress : Route(route = "progress")
    object Quiz: Route(route = "quiz")
    object QuizStart : Route(route = "quiz-start")
    object QuizRunning : Route(route = "quiz-running")
    object QuizEnd : Route(route = "quiz-end")
    object Settings: Route(route = "settings")
}