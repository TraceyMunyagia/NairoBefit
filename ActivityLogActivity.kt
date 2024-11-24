package com.example.nairobefit.ui.theme

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nairobefit.R
import com.example.nairobefit.database.DatabaseInstance
import com.example.nairobefit.database.FoodLogRepository
import com.example.nairobefit.model.ActivityLog
import com.example.nairobefit.model.validateActivityLog
//import kotlinx.android.synthetic.main.activity_activity_log.*
import java.text.SimpleDateFormat
import java.util.*

val Nothing?.text: Any
    get() {
        TODO("Not yet implemented")
    }

class ActivityLogActivity : AppCompatActivity() {
    private lateinit var foodLogRepository: FoodLogRepository  // Reusing the repository, modify it for ActivityLog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_log)

        // Initialize the repository for Activity Log
        val activityLogDao = DatabaseInstance.getDatabase(applicationContext).foodLogDao() // Modify if using separate Dao for activity logs
        foodLogRepository = FoodLogRepository(activityLogDao)  // Reuse repository

        val btnAddActivity = null
        btnAddActivity.setOnClickListener {
                val etActivityName = null
            val activityName = etActivityName.text.toString()
            val etDuration = null
            val duration = etDuration.text.toString()
            val etCaloriesBurned = null
            val caloriesBurned = etCaloriesBurned.text.toString()

            // Validate input
            if (validateActivityLog(activityName, duration, caloriesBurned)) {
                val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                val activityLog = ActivityLog(
                    activityName = activityName,
                    durationMinutes = duration.toInt(),
                    caloriesBurned = caloriesBurned.toInt(),
                    date = date
                )
                saveActivityLog(activityLog)
            } else {
                Toast.makeText(this, "Please enter valid data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to save activity log to the repository/database
    private fun saveActivityLog(activityLog: ActivityLog) {
        // Call repository method to save to the database
        foodLogRepository.saveActivityLog(activityLog)
    }
}

fun Nothing?.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}
