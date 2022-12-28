package com.wahyu.recipes.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @field:SerializedName("results")
    val recipeList: List<RecipeList>,

    @field:SerializedName("offset")
    val offset: Int,

    @field:SerializedName("number")
    val number: Int,

    @field:SerializedName("totalResults")
    val totalResult: Int
)
