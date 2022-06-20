package com.example.diary.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.diary.data.AppDatabase
import com.example.diary.data.dao.NoteDao
import com.example.diary.data.model.Note


class NoteRepository(application: Application) {
    private val noteDao: NoteDao

    private val noteList: LiveData<List<Note>>//DB 수정

    init {
        val db = AppDatabase.getInstance(application)
        noteDao = db!!.noteDao()
        noteList = db.noteDao().getAll()
    }

    fun insert(note: Note) {
        noteDao.insert(note)
    }

    fun delete(note: Note){
        noteDao.delete(note)
    }

    fun getAll(): LiveData<List<Note>> {
        return noteDao.getAll()
    }
}