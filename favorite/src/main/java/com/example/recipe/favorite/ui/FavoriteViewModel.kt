package com.example.recipe.favorite.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel constructor(private val useCase: IRecipesUseCase) : ViewModel() {
    fun getRecipes(): Flow<List<Recipes>> {
        Log.e("YOOO", "getRecipes: I GOt CALLED", )
        return useCase.getFavoriteRecipes()
    }
}