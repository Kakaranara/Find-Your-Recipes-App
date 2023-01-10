package com.wahyu.recipes.core.model

data class RecipeInformation(
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val image: String,
    val summary: String,
    val instruction: String,
)