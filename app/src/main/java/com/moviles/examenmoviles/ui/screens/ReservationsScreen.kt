package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.moviles.examenmoviles.navigation.Screen
import com.moviles.examenmoviles.ui.components.AppBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationsScreen(onBottomItemSelected: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "My Reservations") })
        },
        bottomBar = {
            AppBottomBar(
                currentRoute = Screen.Reservations.route,
                onItemSelected = onBottomItemSelected
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Reservation history coming soon")
        }
    }
}

