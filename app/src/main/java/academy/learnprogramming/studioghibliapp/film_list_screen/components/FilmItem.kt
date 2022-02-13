package academy.learnprogramming.studioghibliapp.film_list_screen.components

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import academy.learnprogramming.studioghibliapp.film_list_screen.FilmListScreenViewModel
import academy.learnprogramming.studioghibliapp.util.Screens.DETAIL_SCREEN
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.request.ImageRequest
import com.google.accompanist.coil.CoilImage


@Composable
fun FilmItem(
    filmItem: FilmListItem,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: FilmListScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    val defaultDominantColor = MaterialTheme.colors.surface
    var dominateColor by remember {
        mutableStateOf(defaultDominantColor)
    }
    Box(
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominateColor,
                        defaultDominantColor
                    )
                )
            )
            .clickable {
                navController.navigate(
                    DETAIL_SCREEN + "${dominateColor.toArgb()}/${filmItem.original_title}"
                )
            }
    ) {
        Column {
            CoilImage(
                request = ImageRequest.Builder(LocalContext.current)
                    .data(filmItem.image)
                    .build(),
                contentDescription = filmItem.description,
                fadeIn = true,
                modifier = Modifier
                    .size(120.dp)
                    .align(CenterHorizontally)
            ){
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.scale(0.5f)
                )
            }
            Text(
                text = filmItem.original_title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

