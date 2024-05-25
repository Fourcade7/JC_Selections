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



data class SelectionHelper constructor(
    val text: String,
    var isSelected:Boolean=false
)


@SuppressLint("MutableCollectionMutableState")
@Composable
fun LazyColumnMultiSelection(selectedItemL:(MutableList<SelectionHelper>)->Unit) {


    var weeklist by remember {
        mutableStateOf(
            mutableListOf(
                SelectionHelper("Понедельник"),
                SelectionHelper("Вторник"),
                SelectionHelper("Среда"),
                SelectionHelper("Четверг"),
                SelectionHelper("Пятница"),
                SelectionHelper("Суббота"),
                SelectionHelper("Воскресенье"),
            )
        )
    }



    Column {


        LazyColumn {

            items(weeklist) {
                LazyItem(item = it){
                    weeklist=mutableListOf<SelectionHelper>().apply { addAll(weeklist) }
                    selectedItemL.invoke(mutableListOf<SelectionHelper>().apply { addAll(weeklist.filter { it.isSelected }) })
                }
            }
        }
    }



}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LazyItem(item:SelectionHelper,onClick:()->Unit) {

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