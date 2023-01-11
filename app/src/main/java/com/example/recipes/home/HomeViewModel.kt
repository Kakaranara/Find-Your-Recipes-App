package com.example.recipes.home

import androidx.lifecycle.ViewModel
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val useCase: IRecipesUseCase) : ViewModel() {
}