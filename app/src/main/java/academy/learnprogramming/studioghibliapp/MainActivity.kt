package academy.learnprogramming.studioghibliapp

import academy.learnprogramming.studioghibliapp.film_list_screen.FilmListScreenViewModel
import academy.learnprogramming.studioghibliapp.ui.theme.StudioGhibliAppTheme
import academy.learnprogramming.studioghibliapp.util.SetupNavGraph
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StudioGhibliApplication : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: FilmListScreenViewModel by viewModels()

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudioGhibliAppTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController, filmListScreenViewModel = viewModel)
            }
        }
    }
}