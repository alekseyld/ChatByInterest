package com.alekseyld.chatbyinterest.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alekseyld.chatbyinterest.ui.conversation.ConversationRoute
import com.alekseyld.chatbyinterest.ui.home.HomeRoute
import com.alekseyld.chatbyinterest.ui.home.HomeViewModel

@ExperimentalMaterialApi
@Composable
fun ChatNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ChatDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ChatDestinations.HOME_ROUTE) {
            HomeRoute()
        }
        composable(ChatDestinations.CONVERSATION_ROUTE) {
            ConversationRoute()
        }
    }
}