package com.wahyu.recipes.core.data.local

import com.wahyu.recipes.core.data.local.database.RecipesDao
import com.wahyu.recipes.core.data.local.entity.FavoriteEntity
import com.wahyu.recipes.core.data.local.entity.RecipeInformationEntity
import com.wahyu.recipes.core.data.local.entity.RecipesEntity
import com.wahyu.recipes.core.model.RecipeInformation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val dao: RecipesDao,
) {
    fun getRecipes(): Flow<List<RecipesEntity>> = dao.getRecipes()
    fun getRecipesInformation(id: Int): Flow<RecipeInformationEntity?> = dao.getRecipeInformation(id)

    suspend fun saveRecipes(recipeList: List<RecipesEntity>) = dao.saveRecipes(recipeList)
    suspend fun saveRecipesInformation(recipe: RecipeInformationEntity) =
        dao.saveRecipeInformation(recipe)

    //? favorite

    fun getFavoriteRecipes(): Flow<List<RecipeInformationEntity>> = dao.getFavoriteRecipe()
    fun updateFavoriteStatus(info: RecipeInformationEntity, state: Boolean) {
        info.isFavorite = state
        dao.updateFavoriteStatus(info)
    }

//    fun getFavoriteRecipes(): Flow<List<FavoriteEntity>> = dao.getFavoriteRecipe()
//    suspend fun saveToFavorite(favoriteEntity: FavoriteEntity) = dao.saveToFavorite(favoriteEntity)
//    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity) = dao.deleteFavorite(favoriteEntity)
//    suspend fun deleteAllFavorite() = dao.deleteAllFavorite()
}