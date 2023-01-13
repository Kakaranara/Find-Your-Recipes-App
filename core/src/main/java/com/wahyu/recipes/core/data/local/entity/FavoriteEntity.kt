package com.wahyu.recipes.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class FavoriteEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val image: String,
    val summary: String,
    val instruction: String,
)
