package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Ingredients : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val recipeId: Column<Int> = integer("recipe_id").references(Recipes.id)
    val name: Column<String> = varchar("name", 255)
    val quantity: Column<String?> = varchar("quantity", 50).nullable()
    val unit: Column<String?> = varchar("unit", 50).nullable()

    override val primaryKey = PrimaryKey(id, name = "PK_Ingredients_ID")
}