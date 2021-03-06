package academy.learnprogramming.studioghibliapp.film_list_screen.components

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import academy.learnprogramming.studioghibliapp.util.FilmItemDummy
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun FilmPanel(
    navController: NavController,
    filmItem: FilmListItem,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .padding(10.dp)
            .shadow(5.dp, RoundedCornerShape(5.dp))
            .clickable {
                navController.navigate(route = "film_detail_screen/" + filmItem.id)
            },
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Row {
            CustomCoilImage(
                url = filmItem.image,
                contentDesc = filmItem.description,
                modifier = Modifier.padding(15.dp)
            )
            Column(
                Modifier.padding(10.dp)
            ) {
                Text(
                    text = filmItem.title,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = modifier
                )
                Text(
                    text = filmItem.description,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    modifier = modifier
                )
            }
        }
    }
}

@Preview
@Composable
fun FilmPanelPreview() {
    FilmPanel(filmItem = FilmItemDummy.item,navController = rememberNavController())
}


