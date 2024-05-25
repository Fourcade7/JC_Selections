@file:OptIn(ExperimentalLayoutApi::class)

package com.pr7.jc_selections

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jc_selections.ui.theme.JC_SelectionsTheme
import kotlin.random.Random

const val TAG="PR77777"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JC_SelectionsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Text(text = "Ui")
                    }
                ) { innerPadding ->
                    
                    Column(modifier = Modifier.padding(innerPadding)) {
                       MainScreen()
                    }
                }
            }
        }
    }
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun MainScreen() {
    var selectedDay by remember {
        mutableStateOf("")
    }
    
    var selectedlist by remember {
        mutableStateOf(mutableListOf<String>())
    }

    var selectedlistMulti by remember {
        mutableStateOf(mutableListOf<SelectionHelper>())
    }
    Column(modifier = Modifier.padding(10.dp)) {

        if (selectedDay.isNotEmpty()){
            CustomCard(text = selectedDay)
        }else{
           CustomCard(text = "Selected Day")
        }


        Spacer(modifier = Modifier.height(10.dp))
        RadioButtonSelection {
            selectedDay=it
        }


        Divider()
        Spacer(modifier = Modifier.height(15.dp))





        CheckBoxSelection{
            selectedlist=it
        }
        Text(text = "Selected days:")
        FlowRow(verticalArrangement = Arrangement.Center) {

            selectedlist.forEach {
                CustomCard(text = it)
            }
        }


        Spacer(modifier = Modifier.height(15.dp))
        Divider()
        Spacer(modifier = Modifier.height(15.dp))

        FlowRow {
            selectedlistMulti.forEach {item->
                Text(text = item.text)
                Spacer(modifier = Modifier.width(10.dp))
                Log.d(TAG, "MainScreen f: $item")

            }
        }

        Row (horizontalArrangement = Arrangement.SpaceBetween){
            LazyColumnMultiSelection{
                selectedlistMulti=it
                Log.d(TAG, "MainScreen: ${it.joinToString()}")
            }
        }


//        LazyColumnSingleSelection{
//            selectedDay=it
//        }

    }
}


@Composable
fun CustomCard(text:String) {
    Card(modifier = Modifier.padding(5.dp)) {
        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
            Text(text = text)
        }

    }
}
























fun getRandomColor() =  Color(
    red = Random.nextInt(256),
    green = Random.nextInt(256),
    blue = Random.nextInt(256),
    alpha = 255
)