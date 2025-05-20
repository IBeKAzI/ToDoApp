package com.example.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todos")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") @NotNull var id: Int = 0,
    @ColumnInfo(name = "name") var  name: String?
) :Serializable