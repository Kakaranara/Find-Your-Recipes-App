package com.wahyu.recipes.core.data

import com.wahyu.recipes.core.data.local.LocalDataSource
import com.wahyu.recipes.core.data.remote.RemoteDataSource
import com.wahyu.recipes.core.domain.repository.IRecipesRepository
import com.wahyu.recipes.core.model.DetailRecipes
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

class RecipesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : IRecipesRepository {
    override fun getRecipes(): Flow<Async<List<Recipes>>> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteRecipes(recipes: DetailRecipes, state: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getRecipesInformation(id: Int): Flow<Async<DetailRecipes>> {
        TODO("Not yet implemented")
    }
}