package cat.itb.m78.exercices

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun LibNavScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.ScreenCalculator) {
        composable<Destination.ScreenCalculator> {
            ScreenCalculator(
                navigateToEnd = { navController.navigate(Destination.ScreenEnd(it)) }
            )
        }
        composable<Destination.ScreenEnd> {
            val result = it.toRoute<Destination.ScreenEnd>().result
            ScreenEnd(result = result)
        }
    }
}