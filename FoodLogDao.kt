package com.example.nairobefit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nairobefit.model.FoodLog

@Dao
interface FoodLogDao {
    @Insert
    suspend fun insert(foodLog: FoodLog)

    @Query("SELECT * FROM foodlog ORDER BY date DESC")
    suspend fun getAllFoodLogs(): List<FoodLog>
    abstract fun getAllLogs(): List<FoodLog>
}
