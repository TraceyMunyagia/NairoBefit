package com.example.fitness2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Fireplace
import androidx.compose.material.icons.rounded.StackedLineChart
import androidx.compose.material.icons.rounded.Stairs
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitness2.data.Calories
import com.example.fitness2.ui.theme.BlueStart
import com.example.fitness2.ui.theme.GreenStart
import com.example.fitness2.ui.theme.PurpleEnd
import com.example.fitness2.ui.theme.PurpleStart

val caloriesList = listOf(
    Calories(
        icon = Icons.Rounded.StarHalf,
        name = "My\nCalories",
        background = PurpleEnd
    ),

    Calories(
        icon = Icons.Rounded.Fireplace,
        name = "My\nCalories Burnt",
        background = BlueStart
    ),

    Calories(
        icon = Icons.Rounded.StackedLineChart,
        name = "Progress\nDone",
        background = PurpleStart
    ),

    Calories(
        icon = Icons.Rounded.Stairs,
        name = "Steps\nLeft",
        background = GreenStart
    ),

)

@Preview
@Composable
fun CaloriesSection(){
    Column {
        Text(
            text = "Calories",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(caloriesList.size){
                CaloriesItem(it)
            }
        }
    }

}

@Composable
fun CaloriesItem(
    index: Int
) {
    val calories = caloriesList[index]
    var lastPaddingEnd = 0.dp
    if (index == caloriesList.size - 1 ){
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(calories.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = calories.icon,
                    contentDescription = calories.name,
                    tint = Color.White
                )
            }

            Text(
                text = calories.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }

}