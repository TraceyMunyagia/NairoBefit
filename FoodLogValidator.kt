package com.example.nairobefit.model

fun validateFoodLog(foodName: String, calories: String, protein: String, carbs: String, fats: String): Boolean {
    if (foodName.isBlank() || calories.isBlank() || protein.isBlank() || carbs.isBlank() || fats.isBlank()) {
        return false
    }
    return try {
        calories.toInt()
        protein.toDouble()
        carbs.toDouble()
        fats.toDouble()
        true
    } catch (e: NumberFormatException) {
        false
    }
}
