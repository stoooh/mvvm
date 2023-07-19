package com.example.checkpoint3.fragments.dogs.data

import com.example.checkpoint3.fragments.dogs.domain.Dogs
import com.example.checkpoint3.fragments.dogs.repository.DogsDao
import com.example.checkpoint3.fragments.dogs.repository.DogsRepo
import com.example.checkpoint3.fragments.dogs.repository.toDogsList

class DogRepository(
    private val dogAPI: DogAPI,
    private val dogsDao: DogsDao
    ) {
    suspend fun getDogs(): List<Dogs> {
        return if(NetworkManager.isConnected) {
            val dogsRemote = dogAPI.getDogs()
            val dogsLocal = dogsRemote.toLocalList()
            dogsDao.insertAll(dogsLocal)
            dogsRemote.toDogsList()
        } else {
            dogsDao.getAll().toDogsList()
        }
    }
}