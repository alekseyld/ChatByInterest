package com.alekseyld.chatbyinterest.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alekseyld.chatbyinterest.R

@ExperimentalMaterialApi
@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = viewModel(),
    navigateToConversation: (conversationId: String) -> Unit
) {
    HomeContent(
        navigateToConversation = navigateToConversation
    )
}

@ExperimentalMaterialApi
@Composable
fun HomeContent(
    navigateToConversation: (conversationId: String) -> Unit
) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .padding(top = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(72.dp)
                        .height(3.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFCAD3DE))
                )
            }

            Column(
                modifier = Modifier
                    .padding(
                        top = 25.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ShortGroupCard(
                        resId = R.drawable.ic_game,
                        title = "Игры"
                    ) { navigateToConversation("games") }
                    ShortGroupCard(
                        resId = R.drawable.ic_sport,
                        title = "Спорт"
                    ){ navigateToConversation("sport") }
                    ShortGroupCard(
                        resId = R.drawable.ic_cooking,
                        title = "Кухня"
                    ) { navigateToConversation("cooking") }
                    ShortGroupCard(
                        resId = R.drawable.ic_fishing,
                        title = "Рыбалка"
                    ) { navigateToConversation("fishing") }
                }

                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = stringResource(R.string.title_groups),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(30.dp))
                GroupCard(
                    title = "Любители кошек",
                    subTitle = "г. Уфа, район Сипайлово",
                    count = 10,
                    maxCount = 20,
                )
                Spacer(modifier = Modifier.height(30.dp))
            }
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = 260.dp,
        sheetShape = RoundedCornerShape(topStart = 33.dp, topEnd = 33.dp),
        sheetBackgroundColor = Color(0xFFEBF2FB),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_home_screen),
            contentDescription = null,
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
private fun PreviewHomeContent() {
    HomeContent(
        navigateToConversation = {}
    )
}
