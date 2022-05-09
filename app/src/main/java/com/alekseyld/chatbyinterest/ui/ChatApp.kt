package com.alekseyld.chatbyinterest.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alekseyld.chatbyinterest.ui.theme.ChatByInterestTheme

@Composable
fun ChatApp() {
    ChatByInterestTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            ChatNavigationActions(navController)
        }

        val coroutineScope = rememberCoroutineScope()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: ChatDestinations.HOME_ROUTE

//        val isExpandedScreen = windowSize == WindowSize.Expanded
//        val sizeAwareDrawerState = rememberSizeAwareDrawerState(isExpandedScreen)

    }
}