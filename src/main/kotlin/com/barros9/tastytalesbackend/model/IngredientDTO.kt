package com.barros9.tastytalesbackend.model

import kotlinx.serialization.Serializable

@Serializable
data class IngredientDTO(
    val id: Int,
    val recipeId: Int,
    val name: String,
    val quantity: String?,
    val unit: String?
)