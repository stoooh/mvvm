package com.example.checkpoint3.fragments.dogs.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DogsDao {
    @Query("SELECT * FROM breed")
    fun getAll(): Flow<List<DogsRepo>>

    @Insert
    fun insertAll(vararg dogs: DogsRepo)


}