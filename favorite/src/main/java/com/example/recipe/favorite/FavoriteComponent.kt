package com.example.recipe.favorite

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