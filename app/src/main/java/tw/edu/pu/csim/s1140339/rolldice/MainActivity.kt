package tw.edu.pu.csim.s1140339.rolldice

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.edu.pu.csim.s1140339.rolldice.ui.theme.RollDiceTheme
import androidx.compose.runtime.getValue // 引入 getValue
import androidx.compose.runtime.mutableStateOf // 引入 mutableStateOf
import androidx.compose.runtime.remember // 引入 remember
import androidx.compose.runtime.setValue // 引入 setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RollDiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Dice(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Dice( modifier: Modifier = Modifier) {
    var diceNumber by remember { mutableStateOf(value = 0) }
    val diceImages = listOf(
        R.drawable.dice0, // 索引 0
        R.drawable.dice1, // 索引 1
        R.drawable.dice2, // 索引 2
        R.drawable.dice3, // 索引 3
        R.drawable.dice4, // 索引 4
        R.drawable.dice5, // 索引 5
        R.drawable.dice6  // 索引 6
    )



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

            Text ("請點擊圖片隨機丟骰子\n作者：張舒毓" )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
            painter = painterResource(id =diceImages[diceNumber]),
            contentDescription = "Dice",
            modifier = Modifier
                .clickable {  //點擊時產生 1 到 6 的隨機整數
                    diceNumber = (1..6).random()
                }

            )

    }





}

