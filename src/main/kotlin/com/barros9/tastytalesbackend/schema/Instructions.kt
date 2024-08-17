package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Instructions : IntIdTable() {
    val recipeId: Column<Int> = integer("recipe_id").references(Recipes.id)
    val stepNumber: Column<Int> = integer("step_number")
    val description: Column<String> = text("description")
    val optionalTip: Column<String?> = text("optional_tip").nullable()
}