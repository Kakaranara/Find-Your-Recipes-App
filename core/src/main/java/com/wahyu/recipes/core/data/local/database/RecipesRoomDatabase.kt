package com.wahyu.recipes.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wahyu.recipes.core.data.local.entity.DetailRecipesEntity
import com.wahyu.recipes.core.data.local.entity.RecipeEntity

@Database(entities = [RecipeEntity::class, DetailRecipesEntity::class], version = 1)
abstract class RecipesRoomDatabase : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao
}