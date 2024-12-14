package com.bellogatecaliphate.pagination.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bellogatecaliphate.pagination.ui.main.data.UserRepository
import com.bellogatecaliphate.pagination.ui.main.model.User
import com.bellogatecaliphate.pagination.ui.main.model.UserResponse
import com.bellogatecaliphate.pagination.ui.main.model.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val userRepository: UserRepository): ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    /*fun getUsers(id: Int, noofRecords: Int) = viewModelScope.launch {
        _uiState.update { uiState -> uiState.copy(isLoading = true) }

        val result = userRepository.getUser(id, noofRecords)
        if (result == null) {
            _uiState.update { uiState -> uiState.copy(isLoading = false, networkError = true) }
        } else {
            _uiState.update { uiState -> uiState.copy(isLoading = false, networkError = false, listOfUsers = convertResponse(result)) }
        }
    }*/

    fun getUsers() = userRepository.getUsers().flow.cachedIn(viewModelScope)

    private fun convertResponse(list: List<UserResponse>): List<User> {
        val result: MutableList<User> = mutableListOf()
        list.forEach { result.add(it.toUser()) }
        return result
    }
}