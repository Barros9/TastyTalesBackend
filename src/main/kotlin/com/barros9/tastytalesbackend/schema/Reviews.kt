package com.barros9.tastytalesbackend.schema

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Reviews : IntIdTable() {
    val recipeId: Column<Int> = integer("recipe_id").references(Recipes.id)
    val user: Column<String> = varchar("user", 255)
    val rating: Column<Int> = integer("rating")
    val comment: Column<String?> = text("comment").nullable()
    val date: Column<LocalDateTime> = datetime("date")
}