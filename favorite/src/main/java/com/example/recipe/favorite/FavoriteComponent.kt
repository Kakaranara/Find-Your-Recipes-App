package com.example.recipe.favorite

import android.app.Activity
import android.content.Context
import com.example.recipes.di.FavoriteModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {
    @Component.Builder
    interface Builder{
//        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies) : Builder
        fun build() : FavoriteComponent
    }

    fun inject(fragment: FavoriteFragment)
}