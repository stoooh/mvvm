package com.example.checkpoint3.fragments.dogs.domain

import com.example.checkpoint3.fragments.dogs.data.DogRepository

class DogsUseCase(private val dogsRepository: DogRepository) {
    suspend operator fun invoke() = dogsRepository.getDogs()
}