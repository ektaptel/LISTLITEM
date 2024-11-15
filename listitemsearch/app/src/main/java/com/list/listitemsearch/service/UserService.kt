package com.list.listitemsearch.service

import com.list.listitemsearch.data.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface UserService {
    @GET("search")
    suspend fun searchUsers(@Query("q") query: String): UserResponse
}