package com.example.checkpoint3.fragments.dogs

import com.example.checkpoint3.fragments.dogs.data.DataDependency
import com.example.checkpoint3.fragments.dogs.domain.DogsUseCase

object DomainDependency {

    val getDogsUseCase = DogsUseCase(
        DataDependency.dogsRepository
    )
}