package com.example.recipes.ui.favorite

import androidx.lifecycle.ViewModel
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val useCase: IRecipesUseCase) : ViewModel(){
    fun getRecipes() = useCase.getFavoriteRecipes()
}