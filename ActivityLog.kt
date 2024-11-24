package com.example.nairobefit.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activitylog")
data class ActivityLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val activityName: String,
    val durationMinutes: Int,
    val caloriesBurned: Int,
    val date: String
)
