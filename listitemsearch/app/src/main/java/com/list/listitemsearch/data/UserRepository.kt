package com.list.listitemsearch.data

import com.list.listitemsearch.service.RetrofitInstance

class UserRepository {
    private val api = RetrofitInstance.api

    suspend fun searchUsers(query: String): List<User> {
        return api.searchUsers(query).users
    }
}