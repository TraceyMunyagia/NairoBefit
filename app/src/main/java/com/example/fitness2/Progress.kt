package com.example.fitness2

// ProgressScreen.kt


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Track() = Scaffold(
    topBar = {
        TopAppBar(
            title = { Text("Progress Tracker") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color(0xFF03A9F4),
                titleContentColor = Color.White
            )
        )
    }
) { paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        // Section for Calories Burnt
        CaloriesBurntSection()

        Spacer(modifier = Modifier.height(24.dp))

        // Section for Exercises
        ExercisesSection()
    }
}

@Composable
fun CaloriesBurntSection() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0F4C3))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Calories Burnt",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFF388E3C)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "1500 kcal",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color(0xFFD32F2F)
                )
            )
        }
    }
}

@Composable
fun ExercisesSection() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE3F2FD))
                .padding(16.dp)
        ) {
            Text(
                text = "Exercises You Can Do",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFF1976D2)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            // List of Exercises
            ExerciseItem("Push-ups")
            ExerciseItem("Squats")
            ExerciseItem("Plank")
            ExerciseItem("Jumping Jacks")
            ExerciseItem("Lunges")
        }
    }
}

@Composable
fun ExerciseItem(exercise: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp), // Corrected syntax with '='
        verticalAlignment = Alignment.CenterVertically // Alignment placed correctly
    ) {
        Text(
            text = "•",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF1976D2)
            ),
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = exercise,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            )
        )
    }
}
