package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object IngredientsTranslations : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val ingredientId: Column<Int> = integer("ingredient_id").references(Ingredients.id)
    val language: Column<String> = varchar("language", 10) // Es. "en", "es", "it"
    val name: Column<String> = varchar("name", 255)
    val quantity: Column<String?> = varchar("quantity", 50).nullable()
    val unit: Column<String?> = varchar("unit", 50).nullable()

    override val primaryKey = PrimaryKey(id, name = "PK_IngredientsTranslations_ID")
}