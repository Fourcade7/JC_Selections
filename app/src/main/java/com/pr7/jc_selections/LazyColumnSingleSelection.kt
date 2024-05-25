@file:OptIn(ExperimentalMaterial3Api::class)

package com.pr7.jc_selections

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp





@SuppressLint("MutableCollectionMutableState")
@Composable
fun LazyColumnSingleSelection(selectedItemL:(String)->Unit) {


    var weeklist by remember {
        mutableStateOf(
            mutableListOf(
                "Понедельник",
                "Вторник",
                "Среда",
                "Четверг",
                "Пятница",
                "Суббота",
                "Воскресенье"
            )
        )
    }

    var selectedList by remember {
        mutableStateOf(mutableListOf<String>())
    }

    var selectedItem by remember {
        mutableStateOf("")
    }



    LazyColumn {
        items(weeklist) {
            LazyItem(text = it, showIcon = selectedItem==it){
                selectedItem=it
                selectedItemL.invoke(selectedItem)
            }
        }
    }

}


@Composable
private fun LazyItem(text: String,showIcon:Boolean,onClick:()->Unit) {

    Card(
        modifier = Modifier.padding(1.dp),
        onClick = {
            onClick.invoke()
        }
    ) {
        Row(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)

        ) {
            Text(text = text)

            if (showIcon){
                Icon(imageVector = Icons.Filled.Done, contentDescription ="D" )
            }

        }

    }
}
