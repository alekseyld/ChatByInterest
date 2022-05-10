package com.alekseyld.chatbyinterest.ui.home

import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GroupCard(
    title: String,
    subTitle: String,
    count: Int,
    maxCount: Int
) {

    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFC1E3FE)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    title,
                    fontSize = 16.sp,
                )
                Text(
                    subTitle,
                    fontSize = 14.sp,
                    color = Color(0xFF69839A),
                )
            }

            Canvas(Modifier.size(50.dp)) {
                drawArc(
                    color = Color(0xFF92BDF5),
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(
                        width = 5.dp.toPx()
                    )
                )
                drawArc(
                    color = Color(0xFF1D6BE5),
                    startAngle = 90f,
                    sweepAngle = -360f * count / maxCount.toFloat(),
                    useCenter = false,
                    style = Stroke(
                        width = 5.dp.toPx(),
                        join = StrokeJoin.Bevel,
                        cap = StrokeCap.Round,
                        miter = 0f,
                    )
                )
                drawIntoCanvas {
                    val paint = Paint().apply {
                        textSize = 16.sp.toPx()
                        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                    }

                    val textRect = Rect()
                    paint.getTextBounds(
                        count.toString(),
                        0,
                        count.toString().length,
                        textRect
                    )

                    it.nativeCanvas.drawText(
                        count.toString(),
                        25.dp.toPx() - textRect.centerX(),
                        25.dp.toPx() - textRect.centerY(),
                        paint
                    )
                }
            }
        }

    }

}

@Preview
@Composable
fun PreviewGroupCard() {
    GroupCard(
        title = "Любители кошек",
        subTitle = "г. Уфа, район Сипайлово",
        count = 10,
        maxCount = 20,
    )
}