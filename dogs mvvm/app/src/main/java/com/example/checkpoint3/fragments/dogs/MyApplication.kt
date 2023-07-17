package com.example.checkpoint3.fragments.dogs

import android.app.Application
import androidx.room.Room

class MyApplication : Application() {

    private lateinit var db : DogsDatabase.AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            DogsDatabase.AppDatabase::class.java, "dogs_database"
        ).build()
    }
}