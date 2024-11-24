package com.example.nairobefit.database

import com.example.nairobefit.model.FoodLog

class ActivityLogRepository(private val foodLogDao: FoodLogDao) {
    suspend fun saveFoodLog(foodLog: FoodLog) {
        foodLogDao.insert(foodLog)
    }

    suspend fun getAllFoodLogs(): List<FoodLog> {
        return foodLogDao.getAllLogs()
    }
}
