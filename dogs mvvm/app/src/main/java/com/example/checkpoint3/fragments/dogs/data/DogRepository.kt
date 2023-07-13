package com.example.checkpoint3.fragments.dogs.data

import com.example.checkpoint3.fragments.dogs.domain.Dogs

class DogRepository(private val dogAPI: DogAPI) {
    suspend fun getDogs() = dogAPI.getDogs()
        .map { Dogs(it.breed, it.img) }
}