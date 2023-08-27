package com.andrograf.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andrograf.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface (
                    color = Color.White
                ){
                    DiceRollerApp()
                }
            }
        }
    }
}

/**
 * represents the UI components of the layout
 * and also holds the button-click and image-display logic
 */
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // create a delegate
    var result by remember { mutableStateOf(1) }
    // on recomposition, assign an image resource
    val imageResource = when(result){
        1 -> (R.drawable.dice_1)
        2 -> (R.drawable.dice_2)
        3 -> (R.drawable.dice_3)
        4 -> (R.drawable.dice_4)
        5 -> (R.drawable.dice_5)
        else -> (R.drawable.dice_6)
    }
    // composable layout
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // on event, button assign a random number to observable
        Button(
            onClick = { result = (1..6).random() }
        ) {
            Text(stringResource(R.string.roll))
        }
    }
}

/**
 * represents the application
 */
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DiceRollerApp() {
    // set app to fullscreen and align center
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}


