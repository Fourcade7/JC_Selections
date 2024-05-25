package com.pr7.jc_selections

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("MutableCollectionMutableState")
@Composable
fun RadioButtonSelection(selectedItemL:(String)->Unit) {

    var weeklist by remember {
        mutableStateOf(mutableListOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"))
    }

    var selectedList by remember {
        mutableStateOf(mutableListOf<String>().apply { addAll(weeklist) })
    }

    var selectedItem by remember {
        mutableStateOf("")
    }

    FlowRow(maxItemsInEachRow = 2) {
        weeklist.forEach { item->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(shape = ShapeDefaults.ExtraLarge)
                    .clickable {
                    selectedItem=item
                    selectedItemL.invoke(item)
                }
            ) {
                RadioButton(
                    selected = item==selectedItem,
                    onClick = {
                        selectedItem=item
                        selectedItemL.invoke(item)
                    })
                Text(text = item)
            }
        }
    }

}