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
class DetailViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    fun guncelle(todoId: Int, todoName: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val updatedTodo = ToDo(id = todoId, name = todoName)
            toDoRepository.updateToDo(todoId,todoName)
        }
    }
}
