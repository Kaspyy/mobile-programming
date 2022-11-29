package com.example.studentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    private var studentList: ArrayList<String> = ArrayList()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentName: TextView = itemView.findViewById(R.id.studentName)
        val mainLayout: View = itemView.findViewById(R.id.mainLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.student_item,
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.studentName.text = currentItem
        holder.mainLayout.setOnClickListener {
            val intent =
                android.content.Intent(holder.mainLayout.context, UpdateActivity::class.java)
            intent.putExtra("id", position)
            intent.putExtra("name", currentItem)
            holder.mainLayout.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setData(student: ArrayList<String>) {
        this.studentList = student
        notifyDataSetChanged()
    }
}