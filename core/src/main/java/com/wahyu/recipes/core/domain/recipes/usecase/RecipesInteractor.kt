package com.wahyu.recipes.core.domain.recipes.usecase

import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.domain.recipes.repository.IRecipesRepository
import com.wahyu.recipes.core.model.RecipeInformation
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class RecipesInteractor @Inject constructor(private val repository: IRecipesRepository) :
    IRecipesUseCase {
    override fun getRecipes(): Flow<Async<List<Recipes>>> {
        return repository.getRecipes()
    }

    override fun getRecipesInformation(id: Int): Flow<Async<RecipeInformation>> {
        return repository.getRecipesInformation(id)
    }

    override suspend fun setFavoriteRecipes(recipes: RecipeInformation, state: Boolean) {
        repository.setFavoriteRecipes(recipes, state)
    }

    override fun getFavoriteRecipes(): Flow<List<Recipes>> {
        return repository.getFavoriteRecipes()
    }
}