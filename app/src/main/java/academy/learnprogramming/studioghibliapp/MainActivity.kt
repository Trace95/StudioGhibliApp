package academy.learnprogramming.studioghibliapp

import academy.learnprogramming.studioghibliapp.film_list_screen.FilmListScreen
import academy.learnprogramming.studioghibliapp.film_list_screen.FilmListScreenViewModel
import academy.learnprogramming.studioghibliapp.ui.theme.StudioGhibliAppTheme
import academy.learnprogramming.studioghibliapp.util.Screens.DETAIL_SCREEN
import academy.learnprogramming.studioghibliapp.util.Screens.START_SCREEN
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: FilmListScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudioGhibliAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = START_SCREEN) {
                    composable(route = START_SCREEN) {
                    }
                    composable(
                        route = DETAIL_SCREEN,
                        arguments = listOf(
                            navArgument("movieID") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val movieID = remember {
                            it.arguments?.getString("movieID")
                        }

                    }
                }
                FilmListScreen(navController = navController,viewModel = viewModel)
            }
        }
    }
}