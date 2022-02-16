package academy.learnprogramming.studioghibliapp.film_list_screen.components

import academy.learnprogramming.studioghibliapp.R
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.OriginalSize

@ExperimentalCoilApi
@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder(context))
            } else {
                add(GifDecoder())
            }
        }
        .build()
    Column{
        Image(
            painter = rememberImagePainter(
                imageLoader = imageLoader,
                data = R.mipmap.toto,
                builder = {
                    size(OriginalSize)
                }
            ),
            contentDescription = null,
            modifier = Modifier
        )
        Text(text = "Loading...",modifier = modifier.align(Alignment.CenterHorizontally))
    }

}

@Preview
@Composable
fun animationPreview(){
    LoadingAnimation()
}