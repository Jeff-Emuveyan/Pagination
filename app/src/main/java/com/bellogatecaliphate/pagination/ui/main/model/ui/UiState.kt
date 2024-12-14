package com.bellogatecaliphate.pagination.ui.main.model.ui

import com.bellogatecaliphate.pagination.ui.main.model.User

data class UiState (
    val isLoading: Boolean = false,
    val networkError: Boolean = false,
    val listOfUsers: List<User> = emptyList()
)