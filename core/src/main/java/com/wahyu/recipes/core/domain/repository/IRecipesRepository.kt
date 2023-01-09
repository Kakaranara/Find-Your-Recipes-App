package com.wahyu.recipes.core.domain.repository

import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.model.DetailRecipes
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

interface IRecipesRepository {
    fun getRecipes(): Flow<Async<List<Recipes>>>
    fun getRecipesInformation(id: Int): Flow<Async<DetailRecipes>>
    fun setFavoriteRecipes(recipes: Recipes, detail: DetailRecipes, state: Boolean)
    fun getFavoriteRecipes(): Flow<Async<Recipes>>
    fun getFavoriteDetailRecipes(): Flow<Async<DetailRecipes>>
}