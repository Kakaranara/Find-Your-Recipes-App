package com.wahyu.recipes.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeList(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field: SerializedName("image")
    val imageUrl: String,

    @field: SerializedName("imageType")
    val imageType: String
)