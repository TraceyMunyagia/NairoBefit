package com.example.nairobefit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nairobefit.model.ActivityLog

@Dao
interface ActivityLogDao {
    @Insert
    suspend fun insert(ActivityLog: ActivityLog)

    @Query("SELECT * FROM activitylog ORDER BY date DESC")
    suspend fun getAllLogs(): List<ActivityLog>
}