package com.example.fitness2.data

import androidx.compose.ui.graphics.Brush

data class MealPlan(
    val name: String,
    val description: String,
    val calories: Int,
    val imageUrl: String,
    val color: Brush
)
