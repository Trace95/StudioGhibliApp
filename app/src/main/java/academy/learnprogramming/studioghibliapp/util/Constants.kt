package academy.learnprogramming.studioghibliapp.util

object Constants {
    const val BASE_URL = "https://ghibliapi.herokuapp.com/"
    const val LIMIT = 20
}

sealed class Screen(val route: String) {
    object FilmListScreen: Screen(route ="film_list_screen")
    object FilmDetailScreen: Screen(route = "film_detail_screen/{id}")
}

