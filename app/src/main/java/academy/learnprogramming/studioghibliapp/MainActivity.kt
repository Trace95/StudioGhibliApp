package academy.learnprogramming.studioghibliapp

import academy.learnprogramming.studioghibliapp.FilmListScreen.FilmListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import academy.learnprogramming.studioghibliapp.ui.theme.StudioGhibliAppTheme
import academy.learnprogramming.studioghibliapp.util.Screens.DETAIL_SCREEN
import academy.learnprogramming.studioghibliapp.util.Screens.START_SCREEN
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudioGhibliAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = START_SCREEN){
                    composable(route = START_SCREEN) {

                    }
                    composable(
                        route = DETAIL_SCREEN,
                        arguments = listOf(
                            navArgument("dominateColor") {
                                type = NavType.IntType
                            },
                            navArgument("movieTitle") {
                                type = NavType.StringType
                            }
                        )
                    ){
                        val dominateColor = remember {
                            val color = it.arguments?.getInt("dominateColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val movieTitle = remember {
                            it.arguments?.getString("movieTitle")
                        }
                        FilmListScreen(navController = navController)
                    }
                }
            }
        }
    }
}