@file:OptIn(ExperimentalMaterial3Api::class)

package com.pr7.jc_selections

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp






//@Composable
//private fun CategoryScreen() {
//
//    var categorys by remember {
//        mutableStateOf(
//            listOf(
//                Category(name = "Работа", image = R.drawable.work),
//                Category(name = "Дом", image = R.drawable.home),
//                Category(name = "Еда", image = R.drawable.food),
//                Category(name = "Образование", image = R.drawable.education),
//                Category(name = "Семья", image = R.drawable.family),
//                Category(name = "Деньги", image = R.drawable.wallet),
//                Category(name = "Долг", image = R.drawable.liability),
//                Category(name = "Здоровье", image = R.drawable.health),
//                Category(name = "Спорт", image = R.drawable.sports),
//                Category(name = "GYM", image = R.drawable.gym),
//                Category(name = "Книга", image = R.drawable.book),
//                Category(name = "Одежда", image = R.drawable.clothes),
//                Category(name = "Смотреть", image = R.drawable.watching),
//                Category(name = "Отдых", image = R.drawable.sunbed),
//                Category(name = "Машина", image = R.drawable.car),
//                Category(name = "Я пойду", image = R.drawable.direction),
//                Category(name = "Каникулы", image = R.drawable.holidays),
//            )
//        )
//
//    }
//    var selectedItem by remember {
//        mutableStateOf(Category(name = "Работа", image = R.drawable.work))
//    }
//
//
//    LazyRow(
//        horizontalArrangement = Arrangement.spacedBy(7.dp)
//    ) {
//        items(categorys) {
//            Card(
//
//                border = BorderStroke(width = 1.dp, color = if (selectedItem==it) Color.Green else Color.Transparent),
//                onClick = {
//                    selectedItem=it
////                    categorys=categorys.map {
////                        if (it.isSelected){
////                            it.copy(isSelected = false)
////                        }else{
////                            it.copy(isSelected = true)
////                        }
////
////                    }
//                }
//            ) {
//                Row(
//                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
//                ) {
//                    Icon(
//                        painter = painterResource(id = it.image),
//                        contentDescription = "",
//                        modifier = Modifier.size(20.dp)
//                    )
//                    SpacerStd(width = 5)
//                    SmallText(text = it.name)
//                }
//            }
//        }
//    }
//}



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
