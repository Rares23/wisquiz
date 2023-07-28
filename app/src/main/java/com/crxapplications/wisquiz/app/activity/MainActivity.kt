package com.crxapplications.wisquiz.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.crxapplications.wisquiz.core.navigation.RootNavigationGraph
import com.crxapplications.wisquiz.ui.theme.WisQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WisQuizTheme {
                val navController: NavHostController = rememberNavController()
                RootNavigationGraph(navController = navController)
            }
        }
    }
}