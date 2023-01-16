package com.example.recipe.favorite.di

import com.example.recipe.favorite.ui.FavoriteFragment
import com.example.recipes.di.FavoriteModuleDependencies
import dagger.Component

@Component(
    dependencies = [FavoriteModuleDependencies::class],
    modules = [FavoriteModule::class]
)
interface FavoriteComponent {
    @Component.Builder
    interface Builder {
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

    fun inject(fragment: FavoriteFragment)
}