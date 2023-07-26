package com.crxapplications.wisquiz.flows.home.presentation.view

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.crxapplications.wisquiz.R
import com.crxapplications.wisquiz.core.navigation.Route
import com.crxapplications.wisquiz.flows.home.presentation.view_data.BottomNavItem
import com.crxapplications.wisquiz.ui.theme.withOpacity

@Composable
fun HomeBottomNavigationBar(
    currentPageRoute: String,
    onMenuItemPress: (Route) -> Unit
) {

    val bottomNavItems = listOf(
        BottomNavItem(
            name = stringResource(R.string.quizzes_page_bottom_nav_label),
            route = Route.Quizzes,
            icon = ImageVector.vectorResource(id = R.drawable.ic_quiz)
        ),
        BottomNavItem(
            name = stringResource(R.string.progress_page_bottom_nav_label),
            route = Route.Progress,
            icon = ImageVector.vectorResource(id = R.drawable.ic_head_stats)
        ),
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentPageRoute == item.route.route,
                onClick = { onMenuItemPress(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer.withOpacity(0.9f)
                ),
                icon = {
                    Icon(
                        imageVector = item.icon,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = stringResource(
                            R.string.home_page_bottom_nav_item_content_description,
                            item.name
                        ),
                    )
                },
                label = {
                    Text(
                        text = item.name,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
            )
        }
    }
}