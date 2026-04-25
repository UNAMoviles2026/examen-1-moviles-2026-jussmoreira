package com.moviles.examenmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.moviles.examenmoviles.navigation.BottomNavItem
import com.moviles.examenmoviles.navigation.Screen
import com.moviles.examenmoviles.ui.screens.ReservationsScreen
import com.moviles.examenmoviles.ui.screens.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.SpaceListScreen
import com.moviles.examenmoviles.ui.theme.ExamenMovilesTheme
import com.moviles.examenmoviles.ui.viewmodel.SpacesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenMovilesTheme {
                CoworkingApp()
            }
        }
    }
}

@Composable
fun CoworkingApp(spacesViewModel: SpacesViewModel = SpacesViewModel()) {
    var selectedBottomRoute by remember { mutableStateOf(Screen.SpaceList.route) }
    var selectedSpaceId by remember { mutableStateOf<String?>(null) }

    val onBottomItemSelected: (String) -> Unit = { route ->
        selectedBottomRoute = route
        selectedSpaceId = null
    }

    val showDetail = selectedBottomRoute == Screen.SpaceList.route && selectedSpaceId != null

    when {
        showDetail -> {
            SpaceDetailScreen(
                space = spacesViewModel.getSpaceById(selectedSpaceId.orEmpty()),
                onBack = { selectedSpaceId = null },
                onReserveClick = { selectedSpace -> spacesViewModel.reserveFeedback(selectedSpace) },
                onBottomItemSelected = onBottomItemSelected
            )
        }

        selectedBottomRoute == BottomNavItem.Reservations.route -> {
            ReservationsScreen(onBottomItemSelected = onBottomItemSelected)
        }

        else -> {
            SpaceListScreen(
                spaces = spacesViewModel.spaces,
                onSpaceSelected = { selectedSpace ->
                    selectedSpaceId = selectedSpace.id
                },
                onBottomItemSelected = onBottomItemSelected
            )
        }
    }
}