package com.wahyu.recipes.core.util.mapper

import com.wahyu.recipes.core.data.local.entity.RecipesEntity
import com.wahyu.recipes.core.data.remote.response.RecipesApi
import com.wahyu.recipes.core.model.Recipes

object RecipeMapper {
    fun mapEntityToDomain(from: List<RecipesEntity>): List<Recipes> = from.map { it.toDomain() }
    fun mapDomainToEntity(from: List<Recipes>): List<RecipesEntity> = from.map { it.toEntity() }
    fun mapApiToEntity(from: List<RecipesApi>): List<RecipesEntity> = from.map { it.toEntity() }
}

fun Recipes.toEntity(): RecipesEntity {
    return RecipesEntity(
        id = this.id,
        title = this.title,
        image = this.image
    )
}

fun RecipesApi.toEntity(): RecipesEntity {
    return RecipesEntity(
        id = this.id,
        title = this.title,
        image = this.imageUrl
    )
}

fun RecipesEntity.toDomain(): Recipes {
    return Recipes(
        id = this.id,
        image = this.image,
        title = this.title
    )
}