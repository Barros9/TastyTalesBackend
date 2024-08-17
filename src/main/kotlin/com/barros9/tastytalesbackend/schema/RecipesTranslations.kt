package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object RecipesTranslations : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val recipeId: Column<Int> = integer("recipe_id").references(Recipes.id)
    val language: Column<String> = varchar("language", 10)
    val name: Column<String> = varchar("name", 255)
    val description: Column<String> = text("description")
    val tags: Column<String?> = text("tags").nullable()

    override val primaryKey = PrimaryKey(id, name = "PK_RecipeTranslations_ID")
}