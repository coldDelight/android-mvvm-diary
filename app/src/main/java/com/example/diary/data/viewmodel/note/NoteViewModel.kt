package com.example.diary.data.viewmodel.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.diary.data.model.Note
import com.example.diary.data.repository.NoteRepository


class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NoteRepository(application)
    private val items = repository.getAll()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun delete(note: Note){
        repository.delete(note)
    }

    fun getAll(): LiveData<List<Note>> {
        return items
    }
}