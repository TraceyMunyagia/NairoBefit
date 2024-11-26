package com.example.fitness2

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitness2.data.MealPlan
import com.example.fitness2.ui.theme.BlueEnd
import com.example.fitness2.ui.theme.BlueStart
import com.example.fitness2.ui.theme.GreenEnd
import com.example.fitness2.ui.theme.GreenStart
import com.example.fitness2.ui.theme.Pink80
import com.example.fitness2.ui.theme.Purple80
import com.example.fitness2.ui.theme.PurpleEnd
import com.example.fitness2.ui.theme.PurpleStart

 val mealPlans = listOf(

        MealPlan(
            name = "Keto Diet",
            description = "A high-fat, low-carb diet for weight loss.",
            calories = 1500,
            imageUrl = "https://example.com/keto.jpg",
            color = getColor(Purple80, Pink80)
        ),

        MealPlan(
            name = "Mediterranean Diet",
            description = "Rich in vegetables, fruits, and healthy fats.",
            calories = 1800,
            imageUrl = "https://example.com/keto.jpg",
            color = getColor(GreenStart, GreenEnd)
        ),

        MealPlan(
            name = "Keto Diet",
            description = "A high-fat, low-carb diet for weight loss Like  Eggs and Fish .",
            calories = 1500,
            imageUrl = "https://example.com/mediterranean.jpg",
            color = getColor(PurpleStart, PurpleEnd)
        ),

        MealPlan(
            name = "Vegan Plan",
            description = "A plant-based diet free from animal products.",
            calories = 1600,
            imageUrl = "https://example.com/vegan.jpg",
            color = getColor(BlueStart, BlueEnd)
        ),

        MealPlan(
            name = "Paleo Diet",
            description = "Focuses on whole foods like lean meats and nuts.",
            calories = 2000,
            imageUrl = "https://example.com/paleo.jpg",
            color = getColor(PurpleStart, PurpleEnd)
        )
 )

fun getColor(
    startColor: Color,
    endColor: Color,
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Preview
@Composable
fun MealPlans(){
    LazyColumn {
        items(mealPlans.size){ mealPlan ->
            MealPlanCard(mealPlan)

        }
    }
}

@Composable
fun MealPlanCard(
    mealPlan: Int
){
    val meal = mealPlans[mealPlan]
    var PaddingEnd = 0.dp
    if (mealPlan == mealPlans.size - 1){
        PaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.profile)
    if (meal.name == "Vegan Plan"){
        image = painterResource(id = R.drawable.vegan2)
    }
    if (meal.name == "Keto Diet" ) {
        image = painterResource(id = R.drawable.keto)
    }
    if(meal.name == "Paleo Diet") {
        image = painterResource(id = R.drawable.paleto)
    }
    if (meal.name == "Mediterranean Diet") {
        image = painterResource(id = R.drawable.mediterranean)
    }


    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = PaddingEnd)
    ){
        Column(
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .height(300.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){

            Image(
                painter = image,
                contentDescription = meal.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = meal.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )

            Text(
                text = meal.description,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${meal.calories} kcal",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}








