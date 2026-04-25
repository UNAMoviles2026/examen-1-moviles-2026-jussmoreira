package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.navigation.Screen
import com.moviles.examenmoviles.model.CoworkingSpace
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.SpaceCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceListScreen(
    spaces: List<CoworkingSpace>,
    onSpaceSelected: (CoworkingSpace) -> Unit,
    onBottomItemSelected: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Coworking Spaces",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            )
        },
        bottomBar = {
            AppBottomBar(
                currentRoute = Screen.SpaceList.route,
                onItemSelected = onBottomItemSelected
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(spaces, key = { it.id }) { space ->
                SpaceCard(
                    space = space,
                    onClick = onSpaceSelected
                )
            }
        }
    }
}

