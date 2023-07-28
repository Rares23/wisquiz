package com.crxapplications.wisquiz.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crxapplications.wisquiz.flows.home.presentation.page.HomePage
import com.crxapplications.wisquiz.flows.settings.presentation.page.SettingsPage


@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Route.Root.route,
        startDestination = Route.Home.route
    ) {
        composable(route = Route.Home.route) {
            val homeNavController: NavHostController = rememberNavController()
            val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
            val currentPageRoute = navBackStackEntry?.destination?.route ?: Route.Quizzes.route

            HomePage(
                navController = homeNavController,
                currentPageRoute = currentPageRoute,
                onMenuItemPress = { route ->
                    homeNavController.navigate(
                        route.route
                    ) {
                        launchSingleTop = true
                        popUpTo(homeNavController.graph.findStartDestination().id)
                    }
                },
                onSettingsPress = {
                    navController.navigate(Route.Settings.route)
                })
        }

        quizNavigationGraph(navController = navController)

        composable(route = Route.Settings.route) {
            SettingsPage()
        }
    }
}