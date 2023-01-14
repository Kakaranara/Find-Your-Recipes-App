package com.example.recipes.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.model.RecipeInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeInformationViewModel @Inject constructor(private val useCase: IRecipesUseCase) :
    ViewModel() {
    fun getRecipeInformation(id: Int): Flow<Async<RecipeInformation>> {
        return useCase.getRecipesInformation(id)
    }

    fun setAsFavorite(recipeInformation: RecipeInformation) {
        viewModelScope.launch {

            useCase.setFavoriteRecipes(recipeInformation, true)
        }
    }

    fun setAsUnfavorite(recipeInformation: RecipeInformation) {
        viewModelScope.launch {

            useCase.setFavoriteRecipes(recipeInformation, false)
        }
    }
}