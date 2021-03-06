package com.alekseyld.chatbyinterest.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alekseyld.chatbyinterest.R

@Composable
@ExperimentalMaterialApi
fun ShortGroupCard(
    @DrawableRes resId: Int,
    title: String,
    onClick: () -> Unit,
) {
    Column(
        Modifier.clickable(onClick = onClick)
    ) {

        Card(
            backgroundColor = Color.White,
            modifier = Modifier.size(64.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = resId),
                contentDescription = null,
                modifier = Modifier.padding(all = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .width(64.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                title,
                fontSize = 15.sp,
            )
        }
    }
}