package com.example.checkpoint3.fragments.dogs.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DogsDao {
    @Query("SELECT * FROM breed ORDER BY RANDOM() LIMIT 1")
    fun getAll(): List<DogsRepo>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(breed: List<DogsRepo>)

}