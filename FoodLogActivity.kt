package com.example.nairobefit.ui.theme

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nairobefit.R
import com.example.nairobefit.database.DatabaseInstance
import com.example.nairobefit.database.FoodLogRepository
import com.example.nairobefit.model.FoodLog
import com.example.nairobefit.model.validateFoodLog
//import kotlinx.android.synthetic.main.activity_food_log.*
import java.text.SimpleDateFormat
import java.util.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class FoodLogActivity : AppCompatActivity() {
    private lateinit var foodLogRepository: FoodLogRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_log)

        val foodLogDao = DatabaseInstance.getDatabase(applicationContext).foodLogDao()
        foodLogRepository = FoodLogRepository(foodLogDao)

        val btnAddFood = null
        btnAddFood.setOnClickListener {
            val etFoodName = null
            val foodName = etFoodName.text.toString()
            val etCalories = null
            val calories = etCalories.text.toString()
            val etProtein = null
            val protein = etProtein.text.toString()
            val etCarbs = null
            val carbs = etCarbs.text.toString()
            val etFats = null
            val fats = etFats.text.toString()

            if (validateFoodLog(foodName, calories, protein, carbs, fats)) {
                val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                val foodLog = FoodLog(
                    foodName = foodName,
                    calories = calories.toInt(),
                    protein = protein.toDouble(),
                    carbs = carbs.toDouble(),
                    fats = fats.toDouble(),
                    date = date
                )
                lifecycleScope.launch {
                    saveFoodLog(foodLog)
                }
            } else {
                Toast.makeText(this, "Please enter valid data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun saveFoodLog(foodLog: FoodLog) {
        // Call repository method to save the data to the database
        foodLogRepository.saveFoodLog(foodLog)
    }

    fun Nothing?.setOnClickListener(function: () -> Unit) {
        TODO("Not yet implemented")
    }
}
