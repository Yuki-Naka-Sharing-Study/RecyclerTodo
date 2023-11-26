package com.example.recyclertodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val todolist:ArrayList<TodoData>): RecyclerView.Adapter<RecyclerAdapter.ViewHolderItem>() {

    // ViewHolder (インナークラス)
    inner class ViewHolderItem(v:View): RecyclerView.ViewHolder(v) {
        val tvHolder: TextView = v.findViewById(R.id.tv)
    }

    // 1行だけのViewを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    // position番目のデータをレイアウト(xml)に表示するようセット
    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        val currentItem = todolist[position] // 何番目のリスト (アイテム)　かを指定
        holder.tvHolder.text = currentItem.myTodo // そのリストの中の要素を指定して代入
    }

    // リストサイズ
    override fun getItemCount(): Int {
        return todolist.size
    }


}