package com.barros9.tastytalesbackend.schema

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object InstructionsTranslations : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val instructionId: Column<Int> = integer("instruction_id").references(Instructions.id)
    val language: Column<String> = varchar("language", 10)
    val description: Column<String> = text("description")
    val optionalTip: Column<String?> = text("optional_tip").nullable()

    override val primaryKey = PrimaryKey(id, name = "PK_InstructionsTranslations_ID")
}