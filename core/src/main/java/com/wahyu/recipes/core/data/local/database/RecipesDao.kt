package com.wahyu.recipes.core.data.local.database

import androidx.room.Dao
import androidx.room.Delete
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

    @Query("SELECT * FROM detail where id = :recipesId LIMIT 1")
    fun getRecipeInformation(recipesId: Int): Flow<RecipeInformationEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipes(recipeEntity: List<RecipesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipeInformation(recipesInformation: RecipeInformationEntity)

    //? favorites

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToFavorite(favoriteEntity: FavoriteEntity)

    @Delete
    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity)

    @Query("DELETE FROM favorite")
    suspend fun deleteAllFavorite()

    @Query("SELECT * FROM favorite")
    fun getFavoriteRecipe(): Flow<List<FavoriteEntity>>

}