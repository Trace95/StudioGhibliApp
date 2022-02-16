package academy.learnprogramming.studioghibliapp.film_list_screen

import academy.learnprogramming.studioghibliapp.R
import academy.learnprogramming.studioghibliapp.film_list_screen.components.FilmList
import academy.learnprogramming.studioghibliapp.film_list_screen.components.LoadingAnimation
import academy.learnprogramming.studioghibliapp.film_list_screen.components.SearchBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants

@Composable
fun FilmListScreen(
    navController: NavController,
    viewModel: FilmListScreenViewModel,
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxHeight()
        ) {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.mipmap.ic_banner_foreground),
                contentDescription = "Studio Ghibli Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .align(CenterHorizontally)
            )
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Search behaviour
            }
            FilmList(navController = navController, filmList = viewModel.filmList.value)
            Box( modifier = Modifier.align(alignment = CenterHorizontally)) {
                LoadingAnimation()
            }
        }
    }
}


@Preview
@Composable
fun FilmListScreenPreview() {

    Column {
        Spacer(Modifier.height(20.dp))
        Image(
            painter = painterResource(R.mipmap.ic_banner_foreground),
            contentDescription = "Studio Ghibli Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .align(CenterHorizontally)
        )
        SearchBar(
            hint = "Search...",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // THIS IS THE PREIVEW
        }
    }
}

