package com.example.diary.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.diary.data.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getAll(): LiveData<List<Note>>

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}