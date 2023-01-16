package com.example.recipe.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.domain.recipes.usecase.RecipesInteractor
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val useCase: RecipesInteractor) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FavoriteViewModel::class.java)){
            return FavoriteViewModel(useCase) as T
        }
        return super.create(modelClass)
    }
}