package com.wahyu.recipes.core.data.remote

sealed class ApiResponse<R> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Error(val error: String) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}