package com.example.nairobefit.database

//import com.example.nairobefit.model.ActivityLog
import com.example.nairobefit.model.ActivityLog
import com.example.nairobefit.model.FoodLog

class FoodLogRepository(private val foodLogDao: FoodLogDao) {
    val save: Unit = Unit

    suspend fun saveFoodLog(foodLog: FoodLog) {
        foodLogDao.insert(foodLog)
    }

    suspend fun getAllFoodLogs(): List<FoodLog> {
        return foodLogDao.getAllLogs()
    }

    fun saveActivityLog(activityLog: ActivityLog) {
        TODO("Not yet implemented")
    }

}
