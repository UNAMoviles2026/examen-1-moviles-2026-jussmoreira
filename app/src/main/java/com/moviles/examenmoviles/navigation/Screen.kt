package com.moviles.examenmoviles.navigation

sealed class Screen(val route: String) {
    data object SpaceList : Screen("space_list")
    data object Reservations : Screen("reservations")
    data object SpaceDetail : Screen("space_detail")
}

