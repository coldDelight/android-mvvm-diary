package com.example.diary.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    var title: String,
    var content: String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}