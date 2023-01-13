package com.wahyu.recipes.core.data

import com.wahyu.recipes.core.data.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result: Flow<Async<ResultType>> = flow {
        emit(Async.Loading())
        val db = loadFromDb().first()
        if (shouldFetch(db)) {
            emit(Async.Loading())
            val client = createCall().first()
            when (client) {
                is ApiResponse.Success -> {
                    saveCallResult(client.data)
                    emitAll(loadFromDb().map { Async.Success(it) })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    val data = loadFromDb().first()
                    emit(Async.Error(client.message, data))
                }
            }
        } else {
            emitAll(loadFromDb().map { Async.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}
    protected abstract fun loadFromDb(): Flow<ResultType>
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>
    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Async<ResultType>> = result

}