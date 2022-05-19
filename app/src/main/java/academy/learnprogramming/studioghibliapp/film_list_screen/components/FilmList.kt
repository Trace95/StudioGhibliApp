package academy.learnprogramming.studioghibliapp.film_list_screen.components

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun FilmList(
    navController: NavController,
    filmList: FilmList,
) {
    LazyColumn(
        content = {
            items(filmList) { film: FilmListItem ->
                FilmPanel(filmItem = film, navController = navController)
            }
        })

}


