package com.example.todoapp.data.datasource

import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(private val toDoDao: ToDoDao) {

    suspend fun addToDo(todo_name: String) {
        val newToDo = ToDo(0, todo_name)
        toDoDao.insertToDo(newToDo)
    }

    suspend fun updateToDo(todo_id: Int, todo_name: String) {
        val updatedToDo = ToDo(todo_id, todo_name)
        toDoDao.updateToDo(updatedToDo)
    }

    suspend fun deleteToDo(todo_id: Int) {
        val deletedToDo = ToDo(todo_id, "")
        toDoDao.deleteToDo(deletedToDo)
    }

    suspend fun getAllToDos(): List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDoDao.getAllToDos()
    }

    suspend fun searchToDos(query: String): List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDoDao.searchToDos(query)
    }
}
