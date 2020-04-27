package com.example.retrofittest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.employee_item.view.*


class EmployeeAdapter(private val context: Context, private val items: ArrayList<Employee>)
    : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.employee_item,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textName.text = items[position].employeeName
        holder.textAge.text = items[position].employeeAge.toString()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textName: TextView = view.item_text_name
        val textAge: TextView = view.item_text_age
    }

}