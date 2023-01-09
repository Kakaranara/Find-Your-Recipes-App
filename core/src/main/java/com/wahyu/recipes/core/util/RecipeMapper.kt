package com.wahyu.recipes.core.util

import com.wahyu.recipes.core.data.local.entity.RecipeEntity
import com.wahyu.recipes.core.data.remote.response.RecipeApi
import com.wahyu.recipes.core.model.Recipes

object RecipeMapper {
    fun responseToEntities(data: List<RecipeApi>): List<RecipeEntity> {
        return data.map {
            RecipeEntity(
                id = it.id,
                title = it.title,
                image = it.imageUrl
            )
        }
    }

    fun entityToDomain(entity: List<RecipeEntity>): List<Recipes> {
        return entity.map {
            Recipes(
                id = it.id,
                image = it.image,
                title = it.title
            )
        }
    }

    fun domainToEntity(domain: List<Recipes>): List<RecipeEntity> {
        return domain.map {
            RecipeEntity(
                id = it.id,
                title = it.title,
                image = it.image
            )
        }
    }
}