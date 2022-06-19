package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val noteList = arrayListOf<NoteItem>()      // 아이템 배열
    private val noteAdapter = NoteAdapter(noteList)     // 어댑터


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.noteList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.noteList.layoutManager = GridLayoutManager(this,2)
        binding.noteList.adapter = noteAdapter

        // 아이템 추가
        noteList.add(NoteItem("텍스트 노트1", "010-1234-5678","6월7일"))
        noteList.add(NoteItem("James", "010-1234-567","6월7일"))
        noteList.add(NoteItem("John", "010-1234-5678","6월7일"))
        noteList.add(NoteItem("Cena", "010-1234-5678","6월7일"))
        noteList.add(NoteItem("Cena", "010-1234-5678","6월7일"))
        noteList.add(NoteItem("Cena", "010-1234-5678","6월7일"))
        // 리스트가 변경됨을 어댑터에 알림
        noteAdapter.notifyDataSetChanged()

        binding.noteList.setOnClickListener {
            Log.d("test", "onCreate: 이게 눌린건기ㅏ ")

        }

        binding.fabMain.setOnClickListener {
            Log.d("test", "onCreate: 눌림")

        }
    }

}