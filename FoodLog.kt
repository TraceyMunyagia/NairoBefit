package com.example.nairobefit.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foodlog")
data class F(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,  // Automatically generate an ID
    val foodName: String,  // Food Name
    val calories: Int,  // Calories
    val protein: Double,  // Protein content
    val carbs: Double,  // Carbohydrates
    val fats: Double,  // Fat content
    val date: String  // Date when the log was created
)
