package com.example.studentlist

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val activity: Activity, val studentList: ArrayList<String>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.studentName.text = currentItem
        holder.mainLayout.setOnClickListener {
            val intent = Intent(holder.itemView.context, EditActivity::class.java)
            intent.putExtra("studentName", currentItem)
            holder.itemView.context.startActivity(intent)
            activity.startActivityForResult(intent, 1)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentName: TextView = itemView.findViewById(R.id.studentName)
        val mainLayout: View = itemView.findViewById(R.id.mainLayout)
    }
}