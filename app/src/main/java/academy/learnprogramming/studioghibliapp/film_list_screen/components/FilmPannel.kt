package academy.learnprogramming.studioghibliapp.film_list_screen.components

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import academy.learnprogramming.studioghibliapp.util.FilmItemDummy
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilmPanel(
    filmItem: FilmListItem,
    // navController: NavController,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
//            .shadow(5.dp, RoundedCornerShape(5.dp))
            .clickable {
//                navController.navigate(
//                    DETAIL_SCREEN
//                )
            }
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
                    text = "Desc: " + filmItem.description,
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
fun FilmPannelPreview() {
    FilmPanel(filmItem = FilmItemDummy.item)
}


