package academy.learnprogramming.studioghibliapp.film_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CustomCoilImage(
    url: String,
    contentDesc: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        val painter = rememberImagePainter(
            data = url,
            builder = {
            }
        )
        Image(painter = painter, contentDescription = contentDesc)
    }
}


@Preview
@Composable
fun PreviewCustomCoilImage(){
    CustomCoilImage(url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg", contentDesc = "Blah" )
}