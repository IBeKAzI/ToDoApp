package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.*
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var toDoRepository: ToDoRepository
) : ViewModel() {

    var _toDoList = MutableLiveData<List<ToDo>>()

    init {
        loadToDos()
    }

    fun loadToDos() {
        CoroutineScope(Dispatchers.Main).launch {
            _toDoList.value = toDoRepository.getAllToDos()
        }
    }

    fun search(query: String) {
        CoroutineScope(Dispatchers.Main).launch {
            _toDoList.value = toDoRepository.searchToDos(query)
        }
    }

    fun delete(id :Int) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.deleteToDo(id)
            loadToDos() // güncel listeyi çek
        }
    }
}
