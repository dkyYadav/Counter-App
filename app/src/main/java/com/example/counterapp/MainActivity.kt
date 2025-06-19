package com.example.counterapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme()
        }
    }
}

@Composable
fun CounterAppTheme () {
    Box (modifier = Modifier.fillMaxSize()
        .background(color = colorResource(R.color.holo_blue_light))

    ){
        var count by remember { mutableStateOf(0) }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .height(450.dp).width(360.dp),
                elevation = CardDefaults.cardElevation(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE1EE6A)
                ) // Light blue, you can change to any color
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        text = "Number is $count", fontSize = 35.sp
                    )
                    Spacer(modifier = Modifier.padding(15.dp))

                    Row (modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ){
                        OutlinedButton(onClick = { count++ }
                        ) {
                            Text(text = "Increment")
                        }
                        OutlinedButton(
                            onClick = { count = 0 },

                        ) {
                            Text("Reset", fontSize = 15.sp)
                        }
                        OutlinedButton(onClick = {
                            if (count >= 1){
                                count--}
                        }
                        ) { Text(text = "Decrement")}
                    }
                }

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterAppTheme()


}