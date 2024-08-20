package com.barros9.tastytalesbackend.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileInputStream
import java.util.*

fun Application.configureSettings() {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }
    install(Authentication) {
        basic("auth-basic") {
            realm = "Access to the '/' path"
            validate { credentials ->
                val (storedUsername, storedPassword) = loadCredentials() ?: return@validate null
                if (credentials.name == storedUsername && credentials.password == storedPassword) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
}

fun loadCredentials(): Pair<String, String>? {
    val properties = Properties()
    val localPropertiesFile = File("local.properties")

    if (localPropertiesFile.exists()) {
        FileInputStream(localPropertiesFile).use { inputStream ->
            properties.load(inputStream)
        }
        val username = properties.getProperty("username")
        val password = properties.getProperty("password")

        if (username != null && password != null) {
            return Pair(username, password)
        }
    }
    return null
}