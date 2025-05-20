package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoRepository
import com.example.todoapp.data.entity.ToDo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    fun ekle(todoName: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val newTodo = ToDo(id = 0, name = todoName)
            toDoRepository.addToDo(todoName)
        }
    }
}
