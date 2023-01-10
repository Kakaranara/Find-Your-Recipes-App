package com.wahyu.recipes.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wahyu.recipes.core.data.local.entity.FavoriteEntity
import com.wahyu.recipes.core.data.local.entity.RecipeInformationEntity
import com.wahyu.recipes.core.data.local.entity.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        RecipeInformationEntity::class,
        FavoriteEntity::class
    ],
    version = 1
)
abstract class RecipesRoomDatabase : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao
}