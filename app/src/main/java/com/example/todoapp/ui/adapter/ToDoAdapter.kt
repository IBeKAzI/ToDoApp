package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.databinding.CardTodoBinding
import com.example.todoapp.ui.fragment.HomeFragmentDirections
import com.example.todoapp.ui.viewmodels.HomeViewModel
import com.example.todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class TodoAdapter(
    private val mContext: Context,
    private var todoList: List<ToDo>,
    private val viewModel: HomeViewModel
) : RecyclerView.Adapter<TodoAdapter.CardViewHolder>() {

    inner class CardViewHolder(val binding: CardTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardTodoBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val todo = todoList[position]
        val b = holder.binding

        b.textViewTodoName.text = todo.name

        b.cardViewTodo.setOnClickListener {
            val gecis = HomeFragmentDirections.homeToDetail(todo= todo)
            Navigation.gecisYap(it,gecis)

        }

        b.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "\"${todo.name}\" silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.delete(todo.id)
                }.show()
        }
    }

    override fun getItemCount(): Int = todoList.size
}
