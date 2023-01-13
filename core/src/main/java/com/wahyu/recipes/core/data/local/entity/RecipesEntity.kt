package com.wahyu.recipes.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipesEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val image: String,
)