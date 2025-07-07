package com.example.counterapp.presentation.counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterapp.presentation.viewmodel.CounterViewModel

@Composable
fun Home(    counterViewModel: CounterViewModel = viewModel() // ✅ Lifecycle-aware
) {
    val Counter by counterViewModel.counter.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF6CE8EE))

    ) {
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
                    containerColor = Color(0xFFFFC107)
                ) // Light blue, you can change to any color
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        text = "Number is ${Counter}", fontSize = 35.sp
                    )
                    Spacer(modifier = Modifier.padding(15.dp))

                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        OutlinedButton(onClick = { counterViewModel.increment() }
                        ) {
                            Text(text = "Increment",
                                color = Color.Black)
                        }
                        OutlinedButton(
                            onClick = { counterViewModel.reset() },

                            ) {
                            Text("Reset", fontSize = 15.sp,
                                color = Color.Black)
                        }
                        OutlinedButton(onClick = {
                            if (Counter >= 1) {
                                counterViewModel.decrement()
                            }
                        }
                        ) { Text(text = "Decrement",
                            color = Color.Black)


                        }
                    }
                }
            }
        }
    }
}





