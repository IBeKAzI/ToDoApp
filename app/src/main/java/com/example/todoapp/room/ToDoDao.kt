package com.example.todoapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapp.data.entity.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todos ")
    fun getAllToDos(): List<ToDo>

    @Query("SELECT * FROM todos WHERE name LIKE '%' || :query || '%' ")
    fun searchToDos(query: String): List<ToDo>

    @Insert
    suspend fun insertToDo(todo: ToDo)

    @Update
    suspend fun updateToDo(todo: ToDo)

    @Delete
    suspend fun deleteToDo(todo: ToDo)
}
