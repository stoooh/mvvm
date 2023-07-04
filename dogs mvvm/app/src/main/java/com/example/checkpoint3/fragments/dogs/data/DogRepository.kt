package com.example.checkpoint3.fragments.dogs.data

import com.example.checkpoint3.fragments.dogs.domain.Dogs

class DogRepository(private val DogAPI: DogAPI) {
    suspend fun getDogs() = DogAPI.getDogs()
        .map { Dogs(it.breed, it.img) }
}