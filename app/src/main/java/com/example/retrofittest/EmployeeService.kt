package com.example.retrofittest

import retrofit2.Call
import retrofit2.http.GET


interface EmployeeService {
    @GET("employees")
    suspend fun getEmployees(): EmployeeApiResponse?
}