package com.wahyu.recipes.core.data.local

import com.wahyu.recipes.core.data.local.database.RecipesDao
import com.wahyu.recipes.core.data.local.entity.FavoriteEntity
import com.wahyu.recipes.core.data.local.entity.RecipeInformationEntity
import com.wahyu.recipes.core.data.local.entity.RecipesEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val dao: RecipesDao,
) {
    fun getRecipes(): Flow<List<RecipesEntity>> = dao.getRecipes()
    fun getRecipesInformation(id: Int): Flow<RecipeInformationEntity> = dao.getRecipeInformation(id)
    suspend fun saveRecipes(recipeList: List<RecipesEntity>) = dao.saveRecipes(recipeList)
    suspend fun saveRecipesInformation(recipe: RecipeInformationEntity) =
        dao.saveRecipeInformation(recipe)

    //? favorite

    fun getFavoriteRecipes(): Flow<List<FavoriteEntity>> = dao.getFavoriteRecipe()
    suspend fun saveToFavorite(favoriteEntity: FavoriteEntity) = dao.saveToFavorite(favoriteEntity)
    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity) = dao.deleteFavorite(favoriteEntity)
    suspend fun deleteAllFavorite() = dao.deleteAllFavorite()
}