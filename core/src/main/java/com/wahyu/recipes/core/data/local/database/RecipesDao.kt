package com.wahyu.recipes.core.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wahyu.recipes.core.data.local.entity.DetailRecipesEntity
import com.wahyu.recipes.core.data.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {
    @Query("SELECT * FROM recipes")
    fun getRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM detail where id = :recipesId")
    fun getRecipesInformation(recipesId: Int): Flow<DetailRecipesEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveRecipes(recipeEntity: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveRecipesInformation(recipesInformation: DetailRecipesEntity)
}