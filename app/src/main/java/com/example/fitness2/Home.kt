package com.example.fitness2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
           // BottomNavigationBar(navController = navController)
        }
    ){  padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            ProfileSection()
            WorkoutSection()
            Spacer(modifier = Modifier.height(16.dp))
            CaloriesSection()
            //PlanningSection()

        }

    }
}