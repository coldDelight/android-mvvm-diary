package com.example.diary.dailog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.diary.MainActivity
import com.example.diary.R
import kotlinx.coroutines.Dispatchers

class InputDialog(context: Context) : Dialog(context) {

    // 액티비티에서 인터페이스를 받아옴
//    private var myCustomDialogInterface: InputDialogInterface = myInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_dialog)

        var okButton : Button = findViewById(R.id.okButton)
        var titleEditView : EditText = findViewById(R.id.titleEdit)
        var contentEditView : EditText = findViewById(R.id.contentEdit)

        // 배경 투명하게 바꿔줌
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        okButton.setOnClickListener {
            val title = titleEditView.text.toString()
            val content = contentEditView.text.toString()

            // 입력하지 않았을 때
            if ( TextUtils.isEmpty(content)){
                Toast.makeText(context, "메모를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }

            // 입력 창이 비어 있지 않을 때
            else{
                // 메모를 추가해줌
                Log.d("ddd", "onCreate: ddd")
            }
                dismiss()
            }
        }

        // 취소 버튼 클릭 시 종료
//        cancelButton.setOnClickListener { dismiss()}

}