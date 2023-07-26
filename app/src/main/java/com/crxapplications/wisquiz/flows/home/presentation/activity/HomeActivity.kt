package com.crxapplications.wisquiz.flows.home.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.crxapplications.wisquiz.flows.home.presentation.screen.HomeScreen
import com.crxapplications.wisquiz.ui.theme.WisQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WisQuizTheme {
                HomeScreen()
            }
        }
    }
}