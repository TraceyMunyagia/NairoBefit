package com.example.fitness2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitness2.data.Workout
import com.example.fitness2.ui.theme.BlueEnd
import com.example.fitness2.ui.theme.BlueStart
import com.example.fitness2.ui.theme.PurpleEnd
import com.example.fitness2.ui.theme.PurpleStart



val workouts = listOf(

    Workout(
        workoutType = "Cardio",
        workoutNumber = "1334",
        workoutName = "cycling",
        balance = 43,
        color = getGradient(PurpleStart, PurpleEnd),
    ),

    Workout(
        workoutType = "Biceps",
        workoutNumber = "1335",
        workoutName = "HammerCurls",
        balance = 15,
        color = getGradient(BlueStart, BlueEnd),
    ),

    Workout(
        workoutType = "L",
        workoutNumber = "1334",
        workoutName = "cycling",
        balance = 43,
        color = getGradient(PurpleStart, PurpleEnd),
    ),

    Workout(
        workoutType = "Cardio",
        workoutNumber = "1334",
        workoutName = "cycling",
        balance = 43,
        color = getGradient(PurpleStart, PurpleEnd),
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Preview
@Composable
fun WorkoutSection() {
    LazyRow {
        items(workouts.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val workout = workouts[index]
    var lastItemPaddingEnd = 0.dp
    if (index == workouts.size - 1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.profile)
    if (workout.workoutType == "Cardio"){
        image = painterResource(id = R.drawable.profile)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(workout.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Image(
                painter = image,
                contentDescription = workout.workoutName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = workout.workoutName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Reps ${workout.workoutNumber}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = workout.workoutType,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}