package com.example.recipes

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val mapped = collectMe().map { it.toInt() }
        mapped.collect{
            println("$it : ${it::class.java.simpleName}")
        }
    }
}

fun collectMe() : Flow<String> = flow {
    emit("1")
    emit("3")
    emit("2")
}