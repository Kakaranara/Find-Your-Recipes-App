package com.wahyu.recipes.core.domain.recipes.repository

import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.model.RecipeInformation
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

interface IRecipesRepository {
    fun getRecipes(): Flow<Async<List<Recipes>>>
    fun getRecipesInformation(id: Int): Flow<Async<RecipeInformation>>

    //? favorite related

    fun setFavoriteRecipes(detail: RecipeInformation, state: Boolean)
    fun getFavoriteRecipes(): Flow<List<Recipes>>
    fun getFavoriteRecipeInformation(id: Int): Flow<RecipeInformation>
}