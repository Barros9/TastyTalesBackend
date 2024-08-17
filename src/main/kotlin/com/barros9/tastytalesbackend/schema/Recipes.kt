package com.barros9.tastytalesbackend.schema

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Recipes : IntIdTable() {
    val name: Column<String> = varchar("name", 255)
    val description: Column<String> = text("description")
    val imageUrl: Column<String?> = varchar("image_url", 255).nullable()
    val preparationTime: Column<Int> = integer("preparation_time")
    val cookingTime: Column<Int> = integer("cooking_time")
    val restingTime: Column<Int?> = integer("resting_time").nullable()
    val servings: Column<Int> = integer("servings")
    val difficulty: Column<String> = varchar("difficulty", 50)
    val tags: Column<String?> = text("tags").nullable()
    val mealType: Column<String> = varchar("meal_type", 50)
    val isVegetarian: Column<Boolean> = bool("is_vegetarian")
    val isGlutenFree: Column<Boolean> = bool("is_gluten_free")
    val isDairyFree: Column<Boolean> = bool("is_dairy_free")
    val isNutFree: Column<Boolean> = bool("is_nut_free")
    val spiceLevel: Column<String> = varchar("spice_level", 50)
    val caloriesPerServing: Column<Int?> = integer("calories_per_serving").nullable()
    val author: Column<String?> = varchar("author", 255).nullable()
    val averageRating: Column<Double?> = double("average_rating").nullable()
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime?> = datetime("updated_at").nullable()
}