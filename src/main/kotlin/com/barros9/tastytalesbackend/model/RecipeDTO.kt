package com.barros9.tastytalesbackend.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val ingredients: List<IngredientDTO>,
    val instructions: List<InstructionDTO>,
    val reviews: List<ReviewDTO>?,
    val preparationTime: Int,
    val cookingTime: Int,
    val restingTime: Int?,
    val servings: Int,
    val difficulty: String,
    val tags: String?,
    val mealType: String,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isDairyFree: Boolean,
    val isNutFree: Boolean,
    val spiceLevel: String,
    val caloriesPerServing: Int?,
    val author: String?,
    val averageRating: Double?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)

