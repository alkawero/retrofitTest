package com.example.retrofittest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("employee_name")
    @Expose
    val employeeName: String,

    @SerializedName("employee_salary")
    @Expose
    val employeeSalary: Long,

    @SerializedName("employee_age")
    @Expose
    val employeeAge: Int,

    @SerializedName("profile_image")
    @Expose
    val profileImage: String
)