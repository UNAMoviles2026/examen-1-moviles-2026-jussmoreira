package com.moviles.examenmoviles.navigation

import android.R

enum class BottomNavItem(
    val route: String,
    val label: String,
    val iconRes: Int
) {
    Spaces(
        route = Screen.SpaceList.route,
        label = "Spaces",
        iconRes = R.drawable.ic_menu_view
    ),
    Reservations(
        route = Screen.Reservations.route,
        label = "Reservations",
        iconRes = R.drawable.ic_menu_agenda
    )
}

