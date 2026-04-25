package com.moviles.examenmoviles.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.moviles.examenmoviles.navigation.BottomNavItem

@Composable
fun AppBottomBar(
    currentRoute: String,
    onItemSelected: (String) -> Unit
) {

    NavigationBar {
        BottomNavItem.entries.forEach { item ->
            val isSelected =
                currentRoute == item.route ||
                    (currentRoute == "space_detail" && item.route == "space_list")

            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.label
                    )
                },
                label = { Text(text = item.label) }
            )
        }
    }
}

