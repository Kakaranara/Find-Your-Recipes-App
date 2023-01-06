package com.example.recipes

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val personList = listOf<Person>(Person("yoy"), Person("yay"))
        val peopleList = personList.map {
            println("Yok")
            People(it.name)
        }
        println(peopleList)
    }
}

data class Person(val name: String)
data class People(val name: String)

fun collectMe(): Flow<String> = flow {
    emit("1")
    emit("3")
    emit("2")
}