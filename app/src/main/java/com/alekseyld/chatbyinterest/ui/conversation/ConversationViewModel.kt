package com.alekseyld.chatbyinterest.ui.conversation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alekseyld.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
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
class ConversationViewModel @Inject constructor() : ViewModel() {

    private val viewModelState = MutableStateFlow(ConversationViewModelState(isLoading = true))

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

}

