package com.example.nairobefit.model

fun validateActivityLog(activityName: String, duration: String, caloriesBurned: String): Boolean {
    if (activityName.isBlank() || duration.isBlank() || caloriesBurned.isBlank()) {
        return false
    }
    return try {
        duration.toInt()
        caloriesBurned.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}
