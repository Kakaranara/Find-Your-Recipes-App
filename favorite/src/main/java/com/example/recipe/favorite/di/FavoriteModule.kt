package com.example.recipe.favorite.di

import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.domain.recipes.usecase.RecipesInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

//
@Module
@DisableInstallInCheck
abstract class FavoriteModule {

    @Binds
    abstract fun provideUseCase(interactor: RecipesInteractor): IRecipesUseCase
}