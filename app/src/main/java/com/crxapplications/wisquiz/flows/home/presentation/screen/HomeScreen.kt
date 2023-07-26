package com.crxapplications.wisquiz.flows.home.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crxapplications.wisquiz.core.navigation.Route
import com.crxapplications.wisquiz.core.navigation.HomeNavGraph
import com.crxapplications.wisquiz.flows.home.presentation.view.HomeBottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            HomeBottomNavigationBar(currentPageRoute = navBackStackEntry?.destination?.route
                ?: Route.Quizzes.route,
                onMenuItemPress = { route ->
                    navController.navigate(
                        route.route
                    ) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id)
                    }
                })
        },
    ) { padding ->
        Surface(
            modifier = Modifier.padding(padding)
        ) {
            HomeNavGraph(navController = navController)
        }
    }

}