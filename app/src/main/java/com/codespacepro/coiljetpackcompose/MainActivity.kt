package com.codespacepro.coiljetpackcompose

import android.os.Bundle
import android.view.animation.Transformation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.codespacepro.coiljetpackcompose.ui.theme.CoilJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    CoilImage()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg")
                .crossfade(1000)
                .size(450, 450)
                .build(),
            filterQuality = FilterQuality.High,
            contentScale = ContentScale.Crop,
            transform = AsyncImagePainter.DefaultTransform,
        )
        Image(painter = painter, contentDescription = "Logo Image")
        if (painter.state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(color = Color.Blue)
        } else if (painter.state is AsyncImagePainter.State.Error) {
            CircularProgressIndicator(color = Color.Red)
        }

//        val painter = rememberAsyncImagePainter(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data("https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg")
//                .crossfade(1000)
//                .build(),
//            filterQuality = FilterQuality.High,
//        )
//        Image(painter = painter, contentDescription = "Image")
//        if (painter.state is AsyncImagePainter.State.Loading) {
//            CircularProgressIndicator()
//        } else if (painter.state is AsyncImagePainter.State.Error) {
//            LinearProgressIndicator(
//                color = Color.Green, trackColor = Color.Blue
//            )
//        }

//        val painter = rememberAsyncImagePainter(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data("https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg")
//                .build(),
//            filterQuality = FilterQuality.High,
//            contentScale = ContentScale.Fit
//        )
//        Image(painter = painter, contentDescription = "Google Image")
//        if (painter.state is AsyncImagePainter.State.Success) {
//            CircularProgressIndicator(modifier = Modifier
//                .width(50.dp)
//                .height(50.dp),
//            color = Color.Blue)
//        }
//        val painter = rememberAsyncImagePainter(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data("https://www.google.com/images/branding/googlelogo/1x/googlelogo_light_color_272x92dp.png") // Set the target size to load the image at.
//                .build()
//        )
//
//        if (painter.state is AsyncImagePainter.State.Success) {
//            // This will be executed during the first composition if the image is in the memory cache.
//            CircularProgressIndicator(modifier = Modifier
//                .height(16.dp)
//                .width(16.dp).background(color = Color.Black))
//        }
//        androidx.compose.foundation.Image(
//            painter = painter,
//            contentDescription = "Content Description"
//        )
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoilJetpackComposeTheme {
        Greeting("Android")
    }
}