package com.barros9.tastytalesbackend.schema

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Reviews : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val recipeId: Column<Int> = integer("recipe_id").references(Recipes.id)
    val user: Column<String> = varchar("user", 255)
    val rating: Column<Int> = integer("rating")
    val comment: Column<String?> = text("comment").nullable()
    val date: Column<LocalDateTime> = datetime("date")

    override val primaryKey = PrimaryKey(id, name = "PK_Reviews_ID")
}