package academy.learnprogramming.studioghibliapp.film_list_screen

import academy.learnprogramming.studioghibliapp.R
import academy.learnprogramming.studioghibliapp.film_list_screen.components.SearchBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FilmListScreen(
    navController: NavController,
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
                // Search behaviour
            }
        }
    }

