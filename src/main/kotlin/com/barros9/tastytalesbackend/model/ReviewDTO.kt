package com.barros9.tastytalesbackend.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class ReviewDTO(
    val id: Int,
    val recipeId: Int,
    val user: String,
    val rating: Int,
    val comment: String?,
    val date: LocalDateTime
)