package com.crxapplications.wisquiz.core.navigation

import androidx.navigation.NamedNavArgument

sealed class Route(val route: String, val arguments: List<NamedNavArgument> = emptyList()) {
    object Root : Route(route = "root")
    object Home : Route(route = "home")
    object Quizzes : Route(route = "quizzes")
    object Progress : Route(route = "progress")
    object Quiz : Route(route = "quiz")
    class QuizStart(arguments: List<NamedNavArgument> = emptyList()) :
        Route(route = "quiz-start", arguments = arguments)

    object QuizRunning : Route(route = "quiz-running")
    object QuizEnd : Route(route = "quiz-end")
    object Settings : Route(route = "settings")
}