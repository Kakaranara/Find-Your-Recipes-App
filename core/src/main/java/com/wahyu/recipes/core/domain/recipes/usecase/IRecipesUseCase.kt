package com.wahyu.recipes.core.domain.recipes.usecase

import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.model.DetailRecipes
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

interface IRecipesUseCase {
    fun getRecipes(): Flow<Async<List<Recipes>>>
    fun getRecipesInformation(id: Int): Flow<Async<DetailRecipes>>
    fun setFavoriteRecipes(recipes: DetailRecipes, state: Boolean)
}