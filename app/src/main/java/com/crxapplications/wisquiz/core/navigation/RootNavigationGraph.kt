package com.crxapplications.wisquiz.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.crxapplications.wisquiz.flows.home.presentation.page.HomePage
import com.crxapplications.wisquiz.flows.settings.presentation.page.SettingsPage


fun NavGraphBuilder.rootNavigationGraph(navController: NavHostController) {
    composable(route = Route.Home.route) {
        HomePage(
            rootNavController = navController,
            onSettingsPress = {
                navController.navigate(Route.Settings.route)
            })
    }

    quizNavigationGraph(navController = navController)

    composable(route = Route.Settings.route) {
        SettingsPage()
    }
}