package com.wahyu.recipes.core.domain.recipes.usecase

import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.model.RecipeInformation
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

interface IRecipesUseCase {
    fun getRecipes(): Flow<Async<List<Recipes>>>
    fun getRecipesInformation(id: Int): Flow<Async<RecipeInformation>>
    fun setFavoriteRecipes(recipes: RecipeInformation, state: Boolean)
    fun getFavoriteRecipes() : Flow<List<Recipes>>
}