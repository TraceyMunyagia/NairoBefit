package com.example.fitness2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoGraph
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Fastfood
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fitness2.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home,
        route = "home"
    ),

    BottomNavigation(
        title = "MealPlans",
        icon = Icons.Rounded.Fastfood,
        route = "mealPlans"
    ),

    BottomNavigation(
        title = "track",
        icon = Icons.Rounded.AutoGraph,
        route = "track"
    ),

    BottomNavigation(
        title = "Profile",
        icon = Icons.Rounded.Face,
        route = "profile"
    )
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = false, // You can track selected state for each item
                onClick = {
                    navController.navigate(item.route) // Navigate to the selected route
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                    )
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}

