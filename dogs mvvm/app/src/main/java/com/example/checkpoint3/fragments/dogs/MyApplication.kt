package com.example.checkpoint3.fragments.dogs

import android.app.Application
import androidx.room.Room
import com.example.checkpoint3.fragments.dogs.data.DataDependency
import com.example.checkpoint3.fragments.dogs.data.NetworkManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DataDependency.inject(applicationContext)
    }
}