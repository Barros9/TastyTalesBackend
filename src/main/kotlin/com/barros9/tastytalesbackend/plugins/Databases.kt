package com.barros9.tastytalesbackend.plugins

import org.jetbrains.exposed.sql.Database

fun connectDatabase() {
    Database.connect(
        url = "jdbc:sqlite:src/main/resources/TastyTalesDatabase.db",
        driver = "org.sqlite.JDBC"
    )
}
