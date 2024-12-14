package com.bellogatecaliphate.pagination.ui.main

import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.bellogatecaliphate.pagination.ui.main.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainView2Model @Inject constructor (private val userRepository: UserRepository): ViewModel() {

    fun getUsers(id: Int) = userRepository.getUsersWithLocalPagination(id).flow.map { it.map { it.toUser() } }

}