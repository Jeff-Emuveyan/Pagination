package com.bellogatecaliphate.pagination.ui.main.data.remote
import com.bellogatecaliphate.pagination.ui.main.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/employee")
    suspend fun getUsers(@Query("idStarts") id: Int, @Query("noofRecords") noofRecords: Int): List<UserResponse>
}