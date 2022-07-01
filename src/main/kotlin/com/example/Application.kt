package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import com.example.dao.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    // Load the database config
    DatabaseFactory.init()
    // Call extension functions
    configureRouting()
    configureTemplating()
}
