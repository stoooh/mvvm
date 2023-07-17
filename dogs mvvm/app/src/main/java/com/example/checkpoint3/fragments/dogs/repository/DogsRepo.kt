package com.example.checkpoint3.fragments.dogs.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breed")
data class DogsRepo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val breed: String?
)