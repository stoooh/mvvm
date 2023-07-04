package com.example.checkpoint3.fragments.dogs.data

import com.example.checkpoint3.fragments.dogs.domain.DogsDomainData

class DogRepository(private val DogAPI: DogAPI) {
    suspend fun getDogs() = DogAPI.getDogs()
        .map { DogsDomainData(it.breed, it.img) }
}