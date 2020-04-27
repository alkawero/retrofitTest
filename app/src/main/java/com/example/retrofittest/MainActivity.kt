package com.example.retrofittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list_employee.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val employeeService: EmployeeService = retrofit.create<EmployeeService>(EmployeeService::class.java)

        GlobalScope.launch(Dispatchers.IO) {

            val response = employeeService.getEmployees()

            response?.let{
                if(it.data.isNotEmpty()){
                    launch(Dispatchers.Main) {
                        list_employee.adapter = EmployeeAdapter(applicationContext,
                            it.data as ArrayList<Employee>
                        )
                    }
                }
            }
        }
    }
}
