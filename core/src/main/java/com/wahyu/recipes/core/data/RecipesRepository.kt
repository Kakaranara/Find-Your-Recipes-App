package com.wahyu.recipes.core.data

import com.wahyu.recipes.core.data.local.LocalDataSource
import com.wahyu.recipes.core.data.remote.RemoteDataSource
import com.wahyu.recipes.core.data.remote.network.ApiResponse
import com.wahyu.recipes.core.data.remote.response.RecipesApi
import com.wahyu.recipes.core.data.remote.response.RecipeInformationApi
import com.wahyu.recipes.core.domain.recipes.repository.IRecipesRepository
import com.wahyu.recipes.core.model.RecipeInformation
import com.wahyu.recipes.core.model.Recipes
import com.wahyu.recipes.core.util.mapper.DetailMapper
import com.wahyu.recipes.core.util.mapper.RecipeMapper
import com.wahyu.recipes.core.util.mapper.toDomain
import com.wahyu.recipes.core.util.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecipesRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : IRecipesRepository {
    override fun getRecipes(): Flow<Async<List<Recipes>>> =
        object : NetworkBoundResource<List<Recipes>, List<RecipesApi>>() {
            override fun loadFromDb(): Flow<List<Recipes>> {
                return localDataSource.getRecipes().map {
                    RecipeMapper.mapEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Recipes>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<RecipesApi>>> {
                return remoteDataSource.getRecipe()
            }

            override suspend fun saveCallResult(data: List<RecipesApi>) {
                val entity = RecipeMapper.mapApiToEntity(data)
                localDataSource.saveRecipes(entity)
            }
        }.asFlow()

    override fun getRecipesInformation(id: Int): Flow<Async<RecipeInformation>> =
        object : NetworkBoundResource<RecipeInformation, RecipeInformationApi>() {
            override fun loadFromDb(): Flow<RecipeInformation> {
                return localDataSource.getRecipesInformation(id).map {
                    it?.toDomain() ?: RecipeInformation(0, "", 0, "", "", "")
                }
            }

            override fun shouldFetch(data: RecipeInformation?): Boolean {
                return data == null || data.id == 0
                // ? data.id == 0 is come from loadFromDb() if it was null. assigning to a new object with id == 0 (if null).
                // * because i don't wanna make all object nullable so i do so.
            }

            override suspend fun createCall(): Flow<ApiResponse<RecipeInformationApi>> {
                return remoteDataSource.getRecipeInformation(id)
            }

            override suspend fun saveCallResult(data: RecipeInformationApi) {
                val entity = data.toEntity()
                localDataSource.saveRecipesInformation(entity)
            }
        }.asFlow()

    override fun setFavoriteRecipes(detail: RecipeInformation, state: Boolean) {
        val entity = detail.toEntity()
        localDataSource.updateFavoriteStatus(entity, state)
    }

    override fun getFavoriteRecipes(): Flow<List<Recipes>> {
        return localDataSource.getFavoriteRecipes().map {
            DetailMapper.mapEntitiesToRecipes(it)
        }
    }
}