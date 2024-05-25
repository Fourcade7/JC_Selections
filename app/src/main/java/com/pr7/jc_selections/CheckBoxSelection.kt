package com.pr7.jc_selections

import android.annotation.SuppressLint
import android.widget.CheckBox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalLayoutApi::class)

@Composable
fun CheckBoxSelection(selectedListL:(MutableList<String>)->Unit) {

    var weeklist by remember {
        mutableStateOf(mutableListOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"))
    }

    var selectedList by remember {
        mutableStateOf(mutableListOf<String>())
    }




    FlowRow {
        weeklist.forEach {item->
            var selectedItem by remember {
                mutableStateOf(false)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(ShapeDefaults.ExtraLarge)

            ) {
                Checkbox(
                    checked = selectedItem,
                    onCheckedChange = {
                        selectedItem =it
                        if (it){
                            selectedList.add(item)
                        }else{
                            selectedList.remove(item)
                        }
                        //selectedListL.invoke(mutableListOf<String>().apply{addAll(selectedList)})

                        val selectedListNew= mutableListOf<String>()
                        selectedListNew.addAll(selectedList)
                        selectedListL.invoke(selectedListNew)

                    }
                )
                Text(text = item)
            }
        }


    }

}