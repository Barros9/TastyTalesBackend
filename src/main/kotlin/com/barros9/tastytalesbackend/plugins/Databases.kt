package com.barros9.tastytalesbackend.plugins

import org.jetbrains.exposed.sql.Database

fun connectDatabase() {
    val dbPath = System.getenv("DATABASE_PATH") ?: "src/main/resources/TastyTalesDatabase.db"

    Database.connect(
        url = "jdbc:sqlite:$dbPath",
        driver = "org.sqlite.JDBC"
    )
}
