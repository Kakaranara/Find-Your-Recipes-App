package com.wahyu.recipes.core.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wahyu.recipes.core.data.local.entity.FavoriteEntity
import com.wahyu.recipes.core.data.local.entity.RecipeInformationEntity
import com.wahyu.recipes.core.data.local.entity.RecipesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {
    @Query("SELECT * FROM recipes")
    fun getRecipes(): Flow<List<RecipesEntity>>

    @Query("SELECT * FROM detail where id = :recipesId")
    fun getRecipesInformation(recipesId: Int): Flow<RecipeInformationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipes(recipeEntity: RecipesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipesInformation(recipesInformation: RecipeInformationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToFavorite(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM favorite")
    fun getFavoriteRecipe() : Flow<List<FavoriteEntity>>

}