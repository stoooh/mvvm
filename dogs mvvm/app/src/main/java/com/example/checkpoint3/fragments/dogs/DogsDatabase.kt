package com.example.checkpoint3.fragments.dogs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.checkpoint3.fragments.dogs.repository.DogsDao
import com.example.checkpoint3.fragments.dogs.repository.DogsRepo

class DogsDatabase {
    @Database(entities = [DogsRepo::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun BreedDao(): DogsDao
    }
}