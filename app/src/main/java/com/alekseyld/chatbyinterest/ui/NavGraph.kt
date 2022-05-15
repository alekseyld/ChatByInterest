package com.alekseyld.chatbyinterest.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alekseyld.chatbyinterest.ui.conversation.ConversationRoute
import com.alekseyld.chatbyinterest.ui.home.HomeRoute

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@Composable
fun ChatNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ChatDestinations.HOME_ROUTE,
    navigationActions: ChatNavigationActions,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ChatDestinations.HOME_ROUTE) {
            HomeRoute(
                navigateToConversation = navigationActions.navigateToConversation
            )
        }
        composable(
            "${ChatDestinations.CONVERSATION_ROUTE}/{${ChatDestinations.CONVERSATION_ROUTE_ARG}}",
            arguments = listOf(navArgument(ChatDestinations.CONVERSATION_ROUTE_ARG) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(ChatDestinations.CONVERSATION_ROUTE_ARG)?.let {
                ConversationRoute(
                    conversationId = it
                )
            }
        }
    }
}