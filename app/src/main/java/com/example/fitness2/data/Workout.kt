package com.example.fitness2.data

import androidx.compose.ui.graphics.Brush

data class Workout(
    val workoutType: String,
    val workoutNumber: String,
    val workoutName: String,
    val balance: Int,
    val color: Brush
)
