package com.wahyu.recipes.core.util.mapper

import com.wahyu.recipes.core.data.local.entity.RecipeInformationEntity
import com.wahyu.recipes.core.data.remote.response.RecipeInformationApi
import com.wahyu.recipes.core.model.RecipeInformation
import com.wahyu.recipes.core.model.Recipes

object DetailMapper {
    fun mapEntitiesToRecipes(list: List<RecipeInformationEntity>): List<Recipes> {
        return list.map {
            it.toRecipes()
        }
    }
}

fun RecipeInformationApi.toEntity(): RecipeInformationEntity {
    return RecipeInformationEntity(
        id = this.id ?: 0,
        title = this.title ?: "No Title",
        readyInMinutes = this.readyInMinutes ?: 0,
        image = this.image ?: "",
        summary = this.summary ?: "No Summary",
        instruction = this.instructions ?: "No Instruction"
    )
}

fun RecipeInformationEntity.toDomain(): RecipeInformation {
    return RecipeInformation(
        id = this.id,
        title = this.title,
        readyInMinutes = this.readyInMinutes,
        image = this.image,
        summary = this.summary,
        instruction = this.instruction
    )
}

fun RecipeInformationEntity.toRecipes(): Recipes {
    return Recipes(
        id = this.id,
        image = this.image,
        title = this.title
    )
}

fun RecipeInformation.toEntity(): RecipeInformationEntity {
    return RecipeInformationEntity(
        id = this.id,
        title = this.title,
        readyInMinutes = this.readyInMinutes,
        image = this.image,
        summary = this.summary,
        instruction = this.instruction
    )
}

fun RecipeInformation.toRecipes(): Recipes {
    return Recipes(
        id = this.id,
        image = this.image,
        title = this.title
    )
}