package academy.learnprogramming.studioghibliapp.util

import academy.learnprogramming.studioghibliapp.film_detail_screen.FilmDetailScreen
import academy.learnprogramming.studioghibliapp.film_list_screen.FilmListScreen
import academy.learnprogramming.studioghibliapp.film_list_screen.FilmListScreenViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetupNavGraph(
    navController: NavHostController,
    filmListScreenViewModel: FilmListScreenViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.FilmListScreen.route
    ) {
        // FilmListScreen (Starting Screen)
        composable(
            route = Screen.FilmListScreen.route
        ){
            FilmListScreen(navController = navController, viewModel = filmListScreenViewModel )
        }
        // DetailScreen
        composable(
            route = Screen.FilmDetailScreen.route
        ){
            FilmDetailScreen("123")
        }
    }
}