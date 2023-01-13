package com.wahyu.recipes.core.di

import android.content.Context
import androidx.room.Room
import com.wahyu.recipes.core.data.local.database.RecipesDao
import com.wahyu.recipes.core.data.local.database.RecipesRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RecipesRoomDatabase =
        Room.databaseBuilder(
            context,
            RecipesRoomDatabase::class.java, "recipes.db"
        ).build()

    @Provides
    fun provideDao(database: RecipesRoomDatabase): RecipesDao = database.recipesDao()
}