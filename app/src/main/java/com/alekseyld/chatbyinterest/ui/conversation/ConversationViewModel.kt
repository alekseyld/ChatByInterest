package com.alekseyld.chatbyinterest.ui.conversation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alekseyld.chatbyinterest.ui.ChatDestinations
import com.alekseyld.chatbyinterest.ui.fake.FakeData
import com.alekseyld.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ConversationUiState {

    object Loading : ConversationUiState

    data class Conversions(
        val channelName: String,
        val channelMembers: Int,
        val messages: List<Message>,
    ) : ConversationUiState

}

private data class ConversationViewModelState(
    val channelName: String = "",
    val channelMembers: Int? = null,
    val messages: List<Message> = listOf(),
    val isLoading: Boolean,
) {

    fun toUiState(): ConversationUiState {

        if (channelName.isNotEmpty() && channelMembers != null && !isLoading) {
            return ConversationUiState.Conversions(
                channelName = channelName,
                channelMembers = channelMembers,
                messages = messages,
            )
        }

        return ConversationUiState.Loading;
    }

}

@HiltViewModel
class ConversationViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val viewModelState = MutableStateFlow(ConversationViewModelState(isLoading = true))

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {

        val conversationId =
            savedStateHandle.get<String>(ChatDestinations.CONVERSATION_ROUTE_ARG).orEmpty()

        loadConversation(conversationId)
    }

    private fun loadConversation(conversationId: String) {
        viewModelScope.launch {

            viewModelState.update {
                it.copy(
                    channelName = "Игры $conversationId",
                    channelMembers = 10,
                    isLoading = false,
                    messages = FakeData.initialMessages,
                )
            }

        }
    }

}