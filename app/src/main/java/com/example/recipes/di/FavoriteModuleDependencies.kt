package com.example.recipes.di

import com.wahyu.recipes.core.domain.recipes.usecase.RecipesInteractor
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun provideRecipeUseCase(): RecipesInteractor
}