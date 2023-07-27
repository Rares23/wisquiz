package com.crxapplications.wisquiz.flows.home.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crxapplications.wisquiz.R
import com.crxapplications.wisquiz.core.navigation.Route
import com.crxapplications.wisquiz.core.navigation.HomeNavGraph
import com.crxapplications.wisquiz.flows.home.presentation.view.HomeBottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentPageRoute = navBackStackEntry?.destination?.route ?: Route.Quizzes.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            ImageVector.vectorResource(id = R.drawable.ic_settings),
                            contentDescription = stringResource(
                                id = R.string.settings_icon_cd
                            )
                        )
                    }
                }
            )
        },
        bottomBar = {
            HomeBottomNavigationBar(
                currentPageRoute = currentPageRoute,
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