package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.repo.ToDoRepository
import com.example.todoapp.room.ToDoDao
import com.example.todoapp.room.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao {
        val database = Room.databaseBuilder(context, ToDoDatabase::class.java,"todos.db")
            .createFromAsset("todos.db")
            .build()
        return database.toDoDao()
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDao: ToDoDao): ToDoDataSource {
        return ToDoDataSource(toDoDao)
    }

    @Provides
    @Singleton
    fun provideToDoRepository(toDoDataSource: ToDoDataSource): ToDoRepository {

        return ToDoRepository(toDoDataSource)
    }
}
