package com.wahyu.recipes.core.data.remote.response

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val message: String) : ApiResponse<Nothing>()
}

data class Person(val name: String)

fun main() {
    val person = Person("fafa")
    var a: ApiResponse<Person> = ApiResponse.Success(person)
    a = ApiResponse.Error("fafa")
}