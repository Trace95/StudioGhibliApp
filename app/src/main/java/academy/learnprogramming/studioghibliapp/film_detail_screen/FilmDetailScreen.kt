package academy.learnprogramming.studioghibliapp.film_detail_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FilmDetailScreen(
    movieID: String
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Text(text = movieID)

    }
}

@Preview(showBackground = true)
@Composable
fun FilmDetailScreenPreview(){
    FilmDetailScreen("123")
}