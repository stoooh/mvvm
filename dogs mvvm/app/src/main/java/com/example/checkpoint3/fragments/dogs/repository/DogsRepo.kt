package com.example.checkpoint3.fragments.dogs.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.checkpoint3.fragments.dogs.domain.Dogs

@Entity(tableName = "breed")
data class DogsRepo(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo val breed: String,
    @ColumnInfo val img: String
)

fun DogsRepo.toDogs() = Dogs(id, breed, img)

fun List<DogsRepo>.toDogsList() = map { it.toDogs() }