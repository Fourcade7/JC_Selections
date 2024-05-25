package com.pr7.jc_selections

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.rounded.Done
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



data class SelectionHelperPL constructor(
    val text: String,
    var isSelected:Boolean=false
)


@SuppressLint("MutableCollectionMutableState")
@Composable
fun LazyColumnMultiSelectionPhilipLackner(selectedItemL:(List<SelectionHelperPL>)->Unit) {


    var weeklist by remember {
        mutableStateOf(
            listOf(
                SelectionHelperPL("Понедельник"),
                SelectionHelperPL("Вторник"),
                SelectionHelperPL("Среда"),
                SelectionHelperPL("Четверг"),
                SelectionHelperPL("Пятница"),
                SelectionHelperPL("Суббота"),
                SelectionHelperPL("Воскресенье"),
            )
        )
    }


//    weeklist.filter { it.isSelected }.forEach {
//        Text(text = it.text)
//    }

    Column {


        LazyColumn {

            itemsIndexed(weeklist) {index, item ->  
               Row(
                   horizontalArrangement = Arrangement.SpaceBetween,
                   modifier = Modifier
                       .fillMaxWidth()
                       .clickable {
                        weeklist = weeklist.mapIndexed { j, item2 ->
                            if (index==j){
                                item2.copy(isSelected = !item.isSelected)
                            }else {
                                item2
                            }
                        }
                           selectedItemL.invoke(weeklist)
                       }
                       .padding(16.dp)
               ) {
                   Text(text = item.text)
                   if (item.isSelected){
                       Icon(imageVector = Icons.Rounded.Done, contentDescription ="D" , tint = Color.Green)
                   }
               }
            }
        }
    }



}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LazyItem(item:SelectionHelperPL,onClick:()->Unit) {

    var isSelected by remember {
        mutableStateOf(item.isSelected)
    }
    Card(
        modifier = Modifier.padding(1.dp),
        onClick = {
            item.isSelected=!item.isSelected
            isSelected=item.isSelected
            onClick.invoke()
        }
    ) {
        Row(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)

        ) {
            Text(text = item.text)
            Spacer(modifier = Modifier.weight(1f))
            if (isSelected){
                Icon(imageVector = Icons.Filled.Done, contentDescription ="D" )
            }

        }

    }
}