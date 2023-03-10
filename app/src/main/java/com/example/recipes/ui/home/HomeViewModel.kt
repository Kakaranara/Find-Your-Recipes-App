package com.example.recipes.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: IRecipesUseCase) : ViewModel() {
    fun getRecipeList() = useCase.getRecipes().asLiveData()
}