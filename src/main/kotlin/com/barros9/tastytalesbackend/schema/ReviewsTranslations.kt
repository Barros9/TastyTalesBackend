package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object ReviewsTranslations : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val reviewId: Column<Int> = integer("review_id").references(Reviews.id)
    val language: Column<String> = varchar("language", 10) // Es. "en", "es", "it"
    val comment: Column<String?> = text("comment").nullable()

    override val primaryKey = PrimaryKey(id, name = "PK_ReviewsTranslations_ID")
}