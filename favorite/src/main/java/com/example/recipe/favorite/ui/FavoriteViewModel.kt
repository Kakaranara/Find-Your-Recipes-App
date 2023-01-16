package com.example.recipe.favorite.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.model.Recipes

class FavoriteViewModel constructor(private val useCase: IRecipesUseCase) : ViewModel() {
    fun getRecipes(): LiveData<List<Recipes>> {
        Log.e("YOOO", "getRecipes: I GOt CALLED")
        return useCase.getFavoriteRecipes().asLiveData()
    }
}