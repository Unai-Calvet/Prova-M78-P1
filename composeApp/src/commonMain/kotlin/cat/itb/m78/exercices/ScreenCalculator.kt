package cat.itb.m78.exercices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ScreenCalculator(navigateToEnd: (Int) -> Unit) {
    val viewModel = viewModel { AppViewModel() }
    ScreenCalculator(
        viewModel.resultNumber.value,
        viewModel::changeTypeTo,
        navigateToEnd,
        viewModel::add
    )
}

@Composable
fun ScreenCalculator(
    resNum: Int,
    changeTo: (String) -> Unit,
    navigateToEnd: (Int) -> Unit,
    calculate: (String) -> Unit
) {
    val calNumString = remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(Color.Yellow)
    ) {
        Text(resNum.toString(), fontSize = 2.em)
        Spacer(modifier = Modifier.size(25.dp))
        Box(
            modifier = Modifier.clip(RoundedCornerShape(5.dp)).background(Color.White)
                .size(300.dp, 175.dp).padding(10.dp)
        ) {
            Column {
                Row {
                    Button(onClick = { changeTo("+") }) {
                        Text("+")
                    }
                    Spacer(modifier = Modifier.size(15.dp))
                    Button(onClick = { changeTo("-") }) {
                        Text("-")
                    }
                    Spacer(modifier = Modifier.size(15.dp))
                    Button(onClick = { changeTo("*") }) {
                        Text("*")
                    }
                    Spacer(modifier = Modifier.size(15.dp))
                    Button(onClick = { changeTo("/") }) {
                        Text("/")
                    }
                }
                TextField(
                    calNumString.value,
                    label = { Text("") },
                    onValueChange = { calNumString.value = it })
                Row {
                    Button(onClick = { navigateToEnd(resNum) }) {
                        Text("End")
                    }
                    Spacer(modifier = Modifier.size(85.dp))
                    Button(onClick = { calculate(calNumString.value) }) {
                        Text("Calculate")
                    }
                }
            }
        }
    }
}