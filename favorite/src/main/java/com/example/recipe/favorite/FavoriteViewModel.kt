package com.example.recipe.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.domain.recipes.usecase.RecipesInteractor
import com.wahyu.recipes.core.model.Recipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteViewModel constructor(private val useCase: RecipesInteractor) : ViewModel() {
    fun getRecipes(): Flow<List<Recipes>> {
        Log.e("YOOO", "getRecipes: I GOt CALLED", )
        return useCase.getFavoriteRecipes()
    }
}