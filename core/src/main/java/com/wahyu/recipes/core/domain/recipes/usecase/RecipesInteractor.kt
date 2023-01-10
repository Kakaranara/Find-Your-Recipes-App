package com.wahyu.recipes.core.domain.recipes.usecase

import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.domain.recipes.repository.IRecipesRepository
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.model.DetailRecipes
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

class RecipesInteractor(private val repository: IRecipesRepository) : IRecipesUseCase {
    override fun getRecipes(): Flow<Async<List<Recipes>>> {
        TODO("Not yet implemented")
    }

    override fun getRecipesInformation(id: Int): Flow<Async<DetailRecipes>> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteRecipes(recipes: DetailRecipes, state: Boolean) {
        TODO("Not yet implemented")
    }
}