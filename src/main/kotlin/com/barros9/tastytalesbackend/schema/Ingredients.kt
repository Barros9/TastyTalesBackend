package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Ingredients : IntIdTable() {
    val recipeId: Column<Int> = integer("recipe_id").references(Recipes.id)
    val name: Column<String> = varchar("name", 255)
    val quantity: Column<String?> = varchar("quantity", 50).nullable()
    val unit: Column<String?> = varchar("unit", 50).nullable()
}
