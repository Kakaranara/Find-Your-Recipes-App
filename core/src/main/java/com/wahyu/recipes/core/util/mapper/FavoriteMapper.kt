package com.wahyu.recipes.core.util.mapper

import com.wahyu.recipes.core.data.local.entity.FavoriteEntity
import com.wahyu.recipes.core.model.RecipeInformation
import com.wahyu.recipes.core.model.Recipes

object FavoriteMapper {
    fun mapToRecipes(from: List<FavoriteEntity>) = from.map { it.toRecipes() }
    fun mapToRecipesInformation(from: FavoriteEntity) = from.toRecipeInformation()
}

fun FavoriteEntity.toRecipes(): Recipes {
    return Recipes(
        id = this.id,
        image = this.image,
        title = this.title
    )
}

fun FavoriteEntity.toRecipeInformation(): RecipeInformation {
    return RecipeInformation(
        id = this.id,
        title = this.title,
        readyInMinutes = this.readyInMinutes,
        image = this.image,
        summary = this.summary,
        instruction = this.instruction
    )
}