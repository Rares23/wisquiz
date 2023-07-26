package com.crxapplications.wisquiz.flows.home.presentation.view_data

import androidx.compose.ui.graphics.vector.ImageVector
import com.crxapplications.wisquiz.core.navigation.Route

data class BottomNavItem(
    val name: String,
    val route: Route,
    val icon: ImageVector
)
