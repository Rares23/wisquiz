package com.crxapplications.wisquiz.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.crxapplications.wisquiz.core.navigation.Route
import com.crxapplications.wisquiz.core.navigation.rootNavigationGraph
import com.crxapplications.wisquiz.ui.theme.WisQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WisQuizTheme {
                val navController: NavHostController = rememberNavController()

                NavHost(
                    navController = navController,
                    route = Route.Root.route,
                    startDestination = Route.Home.route
                ) {
                    rootNavigationGraph(navController = navController)
                }
            }
        }
    }
}