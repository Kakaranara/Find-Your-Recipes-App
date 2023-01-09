package com.wahyu.recipes.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class SearchRecipeApi(
    @field:SerializedName("results")
    val result: List<RecipeApi>,

    @field:SerializedName("offset")
    val offset: Int,

    @field:SerializedName("number")
    val number: Int,

    @field:SerializedName("totalResults")
    val totalResult: Int
)


data class RecipeApi(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field: SerializedName("image")
    val imageUrl: String,

    @field: SerializedName("imageType")
    val imageType: String
)
