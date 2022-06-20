package com.example.diary
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diary.data.model.Note
import com.example.diary.databinding.NoteItemBinding

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.TodoViewHolder>() {

    private val items = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NoteItemBinding.inflate(layoutInflater)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(note: List<Note>) {
        items.clear()
        items.addAll(note)
    }

    inner class TodoViewHolder(private val binding: NoteItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(note: Note){
            binding.noteTitle.text = note.title
            binding.noteContent.text = note.content
        }
    }
}