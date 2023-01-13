package com.wahyu.recipes.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail")
data class RecipeInformationEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val image: String,
    val summary: String,
    val instruction: String,
)