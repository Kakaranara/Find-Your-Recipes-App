package com.wahyu.recipes.core.di

import com.wahyu.recipes.core.data.RecipesRepository
import com.wahyu.recipes.core.domain.recipes.repository.IRecipesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideRepository(repository: RecipesRepository) : IRecipesRepository
}