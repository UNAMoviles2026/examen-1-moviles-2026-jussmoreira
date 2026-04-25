package com.moviles.examenmoviles.ui.screens

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.navigation.Screen
import com.moviles.examenmoviles.model.CoworkingSpace
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.AvailabilityBadge
import com.moviles.examenmoviles.ui.components.SpaceInfoRow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceDetailScreen(
    space: CoworkingSpace?,
    onBack: () -> Unit,
    onReserveClick: (CoworkingSpace) -> String,
    onBottomItemSelected: (String) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = space?.name ?: "Space detail") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_media_previous),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            AppBottomBar(
                currentRoute = Screen.SpaceDetail.route,
                onItemSelected = onBottomItemSelected
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        if (space == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Space not found",
                    color = MaterialTheme.colorScheme.error
                )
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = space.imageRes),
                    contentDescription = "Image of ${space.name}",
                    modifier = Modifier.size(96.dp)
                )
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = space.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    AvailabilityBadge(isAvailable = space.isAvailable)
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = space.fullDescription,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))
                SpaceInfoRow(
                    iconRes = R.drawable.ic_dialog_map,
                    label = "Location",
                    value = space.location
                )
                Spacer(modifier = Modifier.height(8.dp))
                SpaceInfoRow(
                    iconRes = R.drawable.ic_menu_myplaces,
                    label = "Capacity",
                    value = "${space.capacity} people"
                )
                Spacer(modifier = Modifier.height(8.dp))
                SpaceInfoRow(
                    iconRes = R.drawable.ic_menu_info_details,
                    label = "Price",
                    value = "$${space.pricePerHour} per hour"
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Amenities",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    space.amenities.forEach { amenity ->
                        SuggestionChip(
                            onClick = {},
                            label = { Text(text = amenity) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        coroutineScope.launch {
                            val feedback = onReserveClick(space)
                            snackbarHostState.showSnackbar(feedback)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = space.isAvailable
                ) {
                    Text(text = if (space.isAvailable) "Reserve now" else "Unavailable")
                }
            }
        }
    }
}

