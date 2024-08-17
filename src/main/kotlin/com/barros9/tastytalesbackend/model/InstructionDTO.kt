package com.barros9.tastytalesbackend.model

import kotlinx.serialization.Serializable

@Serializable
data class InstructionDTO(
    val id: Int,
    val recipeId: Int,
    val stepNumber: Int,
    val description: String,
    val optionalTip: String?
)