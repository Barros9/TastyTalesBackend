package com.barros9.tastytalesbackend

import com.barros9.tastytalesbackend.plugins.configureRouting
import com.barros9.tastytalesbackend.plugins.configureSerialization
import com.barros9.tastytalesbackend.plugins.connectDatabase
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    configureSerialization()
    connectDatabase()
    configureRouting()
}
