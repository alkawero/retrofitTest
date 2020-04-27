package com.example.retrofittest

import com.google.gson.annotations.SerializedName

data class EmployeeApiResponse(
    @SerializedName("data")
    var data: List<Employee>
)