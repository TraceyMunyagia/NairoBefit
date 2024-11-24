package com.example.nairobefit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nairobefit.model.FoodLog

@Database(entities = [FoodLog::class], version = 1, exportSchema = false)
abstract class DatabaseInstance : RoomDatabase() {
    abstract fun foodLogDao(): FoodLogDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseInstance? = null

        fun getDatabase(context: Context): DatabaseInstance {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseInstance::class.java,
                    "food_log_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
