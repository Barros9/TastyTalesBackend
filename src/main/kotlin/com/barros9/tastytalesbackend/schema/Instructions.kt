package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Instructions : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val recipeId: Column<Int> = integer("recipe_id").references(Recipes.id)
    val stepNumber: Column<Int> = integer("step_number")
    val description: Column<String> = text("description")
    val optionalTip: Column<String?> = text("optional_tip").nullable()

    override val primaryKey = PrimaryKey(id, name = "PK_Instructions_ID")
}