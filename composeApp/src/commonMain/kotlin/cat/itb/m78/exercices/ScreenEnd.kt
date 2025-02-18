package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import m78exercices.composeapp.generated.resources.Calculator_icon
import m78exercices.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun ScreenEnd(result: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(Color.Yellow)
    ) {
        Text(" The final result is:", fontSize = 2.em)
        Spacer(modifier = Modifier.size(10.dp))
        Text(result.toString(), fontSize = 4.em)
        Spacer(modifier = Modifier.size(40.dp))
        Image(painter = painterResource(Res.drawable.Calculator_icon), contentDescription = null)
    }
}