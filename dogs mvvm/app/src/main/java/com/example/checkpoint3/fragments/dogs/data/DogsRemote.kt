package com.example.checkpoint3.fragments.dogs.data

import com.example.checkpoint3.fragments.dogs.domain.Dogs
import com.example.checkpoint3.fragments.dogs.repository.DogsDao
import com.example.checkpoint3.fragments.dogs.repository.DogsRepo

data class DogsRemote(
    val id: Int,
    val img : String,
    val breed : String
    )

fun DogsRemote.toDogs() = Dogs(id, breed, img)

fun List<DogsRemote>.toDogsList() = map { it.toDogs() }

fun DogsRemote.toLocal() = DogsRepo(id, breed, img)

fun List<DogsRemote>.toLocalList() = map { it.toLocal() }