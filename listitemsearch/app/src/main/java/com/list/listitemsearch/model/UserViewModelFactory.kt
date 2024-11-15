package com.list.listitemsearch.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.list.listitemsearch.data.UserRepository

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}