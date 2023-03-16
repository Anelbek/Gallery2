package com.example.gallery



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gallery.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PictureGallery()
        }
    }
}

@Composable

fun PictureGallery() {
    var counter by remember { mutableStateOf(1) }
    var text by remember { mutableStateOf(1) }

    val imageResource = when(counter) {
        1 -> R.drawable.toi
        2 -> R.drawable.monna
        3 -> R.drawable.the_two_fridas
        4 -> R.drawable.starry_night
        5 -> R.drawable.landscape_with_carriage_and_train
        else -> R.drawable.two_girls_reading
    }

    val title = when(text) {
        1 -> R.string.kolhoznyi_toi
        2 -> R.string.monna_liza
        3 -> R.string.The_Two_Fridas
        4 -> R.string.The_starry_night
        5 -> R.string.Landscape_with_carriage_and_train
        else -> R.string.two_girls_reading
    }

    val artist = when(text) {
        1 -> R.string.Kasteev
        2 -> R.string.Leonardo_da_Vinci
        3 -> R.string.Frida_Kahlo
        4 -> R.string.Vincent_van_Gogh
        5 -> R.string.Vincent_van_Gogh1
        else -> R.string.Picasso
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(20.dp)) {

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "1",
            modifier = Modifier
                .size(400.dp)
                .padding(0.dp, 50.dp, 0.dp, 0.dp)
        )
        
        Text(text = stringResource(id = title), fontSize = 24.sp, modifier = Modifier.padding(0.dp,50.dp,0.dp,0.dp))

        Text(text = stringResource(id = artist), fontSize = 22.sp)

        Box(modifier = Modifier.fillMaxSize()) {
            if (counter > 1)
                Button(
                    onClick = {
                        counter--
                        text--
                    }, shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(40.dp)
                        .border(1.dp, color = Color.Black)


                ) {
                    Text(text = "Previous", fontSize = 22.sp)
                }

            if (counter < 6)
                Button(
                    onClick = {
                        counter++
                        text++
                    }, shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(40.dp)
                        .border(1.dp, color = Color.Black)
                ) {
                    Text(text = "Next", fontSize = 22.sp)
                }

        }
    }
}



