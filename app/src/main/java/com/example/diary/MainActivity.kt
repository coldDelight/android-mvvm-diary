package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.diary.dailog.InputDialog
import com.example.diary.data.model.Note
import com.example.diary.data.viewmodel.note.NoteViewModel
import com.example.diary.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding // view 바인딩

    private val model: NoteViewModel by  viewModels()
    private lateinit var adapter: NoteAdapter

    private val noteAdapter = NoteAdapter()     // 어댑터


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        model.getAll().observe(this, Observer{
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })

//        binding.fabMain.setOnClickListener {
//            Log.d("test", "onCreate: 이게 눌린건기ㅏ ")
//            lifecycleScope.launch(Dispatchers.IO){
//                model.insert(Note("title","ahhhhhhh"))
//            }
//        }
        binding.fabMain.setOnClickListener {
            Log.d("test", "onCreate: 이게 눌린건기ㅏ ")
            lifecycleScope.launch(Dispatchers.IO){
                model.delete((Note("title","ahhhhhhh")))
            }
        }
//        binding.noteList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.noteList.layoutManager = GridLayoutManager(this,2)
//        binding.noteList.adapter = noteAdapter
        // 아이템 추가
//        noteList.add(NoteItem("텍스트 노트1", "010-1234-5678","6월7일"))
//        noteList.add(NoteItem("James", "010-1234-567","6월7일"))
//        noteList.add(NoteItem("John", "010-1234-5678","6월7일"))
//        noteList.add(NoteItem("Cena", "010-1234-5678","6월7일"))
//        noteList.add(NoteItem("Cena", "010-1234-5678","6월7일"))
//        noteList.add(NoteItem("Cena", "010-1234-5678","6월7일"))
        // 리스트가 변경됨을 어댑터에 알림
//        noteAdapter.notifyDataSetChanged()
        binding.noteList.setOnClickListener {
            Log.d("test", "onCreate: 이게 눌린건기ㅏ ")
        }
    }
    private fun initRecyclerView(){
        binding.noteList.layoutManager = GridLayoutManager(this,2)
        adapter = NoteAdapter()
        binding.noteList.adapter = adapter
    }

    private fun onFabClicked(){
        val myCustomDialog = InputDialog(this)
        myCustomDialog.show()
    }



}