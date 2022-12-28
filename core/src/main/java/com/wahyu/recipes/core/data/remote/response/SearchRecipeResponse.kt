package com.wahyu.recipes.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class SearchRecipeResponse(
    @field:SerializedName("results")
    val result: List<RecipeApiResponse>,

    @field:SerializedName("offset")
    val offset: Int,

    @field:SerializedName("number")
    val number: Int,

    @field:SerializedName("totalResults")
    val totalResult: Int
)
