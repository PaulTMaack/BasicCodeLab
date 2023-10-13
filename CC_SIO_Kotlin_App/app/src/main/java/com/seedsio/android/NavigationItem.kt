package com.seedsio.android

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: Int, val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String) {


}
