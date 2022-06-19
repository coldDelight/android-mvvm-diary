package com.example.diary

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val itemList: ArrayList<NoteItem>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.name.text = itemList[position].title
        holder.number.text = itemList[position].content
        holder.date.text = itemList[position].date

        //아이템 클릭부분
        holder.itemView.setOnClickListener {
            Log.d("test", "onCreate: 이게 눌린건기ㅏ${itemList[position].title} ")
        }
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.note_title)
        val number: TextView = itemView.findViewById(R.id.note_content)
        val date: TextView = itemView.findViewById(R.id.note_date)
    }
}