package com.alekseyld.domain.model

data class Message(
    val author: String,
    val content: String,
    val timestamp: String,
    val imageContentUrl: String? = null,
    val avatarUrl: String? = null,
)
