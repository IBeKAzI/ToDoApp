package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.entity.ToDo

class ToDoRepository(private val toDoDataSource: ToDoDataSource) {

    suspend fun addToDo(name: String) {
        toDoDataSource.addToDo(name)
    }

    suspend fun updateToDo(id: Int, name: String) {
        toDoDataSource.updateToDo(id, name)
    }

    suspend fun deleteToDo(id: Int) {
        toDoDataSource.deleteToDo(id)
    }

    suspend fun getAllToDos(): List<ToDo> {
        return toDoDataSource.getAllToDos()
    }

    suspend fun searchToDos(query: String): List<ToDo> {
        return toDoDataSource.searchToDos(query)
    }
}
