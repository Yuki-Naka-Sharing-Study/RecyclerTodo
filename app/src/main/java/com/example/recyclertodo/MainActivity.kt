package com.example.recyclertodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // 追加リストとRecyclerViewとアダプターを用意
    private var addList = ArrayList<TodoData>() // 空っぽのリストを用意<型はデータクラス>
    private lateinit var recyclerView: RecyclerView
    private var recyclerAdapter = RecyclerAdapter(addList) // アダプターに追加リストをセット

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // viewの取得、アダプターにセット、レイアウトにセット
        recyclerView = findViewById(R.id.rv)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ボタンを押したら
        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val et: EditText = findViewById(R.id.et)
            val data = TodoData(et.text.toString())
            addList.add(data)
            recyclerAdapter.notifyItemInserted(addList.lastIndex) // 表示を更新 (リストの最後に挿入)
            et.text = null
        }
    }

}