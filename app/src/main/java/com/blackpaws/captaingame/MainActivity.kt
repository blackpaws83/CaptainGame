package com.blackpaws.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.blackpaws.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }

    @Composable
    fun CaptainGame() {
//        val shipHP = remember { mutableStateOf(6)}
//        val treasuresFound = remember { mutableStateOf(0) }
//        val direction = remember { mutableStateOf("North") }
//        val stormOrTreasure = remember { mutableStateOf("") }
//        val gameOver = remember { mutableStateOf("") }

        var shipHP by remember { mutableIntStateOf(6) }
        var treasuresFound by remember { mutableIntStateOf(0) }
        var direction by remember { mutableStateOf("North") }
        var stormOrTreasure by remember { mutableStateOf("") }
        var gameOver by remember { mutableStateOf("") }

        Column {
            Text(text = "Ship HP: ${shipHP}")
            Text(text = "Treasures Found: $treasuresFound")
            Text(text = "Current Direction: $direction")
            Text(text = stormOrTreasure)
            Button(onClick = {
                direction = "East"
                if (Random.nextBoolean()) {
                    treasuresFound++
                    stormOrTreasure = "Found a Treasure!"
                } else {
                    stormOrTreasure = "Storm Ahead!"
                    shipHP--
                    if (shipHP == 0) {
                        gameOver = "Game Over. Treasures Found: $treasuresFound"
                    }
                }
            }, enabled = shipHP > 0,
                modifier = Modifier
                    .width(130.dp)
                    .padding(6.dp)
            ) {
                if (shipHP > 0) {
                    Text(text = "Sail East")
                } else {
                    Text(text = "YOU")
                }
            }
            Button(onClick = {
                direction = "West"
                if (Random.nextBoolean()) {
                    treasuresFound++
                    stormOrTreasure = "Found a Treasure!"
                } else {
                    stormOrTreasure = "Storm Ahead!"
                    shipHP--
                    if (shipHP == 0) {
                        gameOver = "Game Over. Treasures Found: $treasuresFound"
                    }
                }
            }, enabled = shipHP > 0,
                modifier = Modifier
                    .width(130.dp)
                    .padding(6.dp)
            ) {
                if (shipHP > 0) {
                    Text(text = "Sail West")
                } else {
                    Text(text = "ARE")
                }
            }
            Button(onClick = {
                direction = "North"
                if (Random.nextBoolean()) {
                    treasuresFound++
                    stormOrTreasure = "Found a Treasure!"
                } else {
                    stormOrTreasure = "Storm Ahead!"
                    shipHP--
                    if (shipHP == 0) {
                        gameOver = "Game Over. Treasures Found: $treasuresFound"
                    }
                }
            }, enabled = shipHP > 0,
                modifier = Modifier
                    .width(130.dp)
                    .padding(6.dp)
            ) {
                if (shipHP > 0) {
                    Text(text = "Sail North")
                } else {
                    Text(text = "DEAD !")
                }
            }
            Button(onClick = {
                direction = "South"
                if (Random.nextBoolean()) {
                    treasuresFound++
                    stormOrTreasure = "Found a Treasure!"
                } else {
                    stormOrTreasure = "Storm Ahead!"
                    shipHP--
                    if (shipHP == 0) {
                        gameOver = "Game Over. Treasures Found: $treasuresFound"
                    }
                }
            }, enabled = shipHP > 0,
                modifier = Modifier
                    .width(130.dp)
                    .padding(6.dp)
            ) {
                if (shipHP > 0) {
                    Text(text = "Sail South")
                } else {
                    Text(text = ":)")
                }
            }
            Text(text = gameOver)
            if (shipHP == 0) {
                Button(
                    onClick = {
                        shipHP = 6
                        treasuresFound = 0
                        direction = "North"
                        stormOrTreasure = ""
                        gameOver = ""
                    }
                ) {
                    Text(text = "Start a New Game?")
                }
            }
        }
    }
}
