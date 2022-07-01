package com.example.dao

import com.example.models.*
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {
    fun init() {
        val driverClassName = "org.h2.Driver"
        val jdbcURL = "jdbc:h2:file:./build/db"
        // Connect to the database
        val database = Database.connect(jdbcURL, driverClassName)
        transaction(database) {
            // SQL statements
            SchemaUtils.create(Articles)  // Create the table if it doesn't yet exist
        }
    }
    // Start each query in its own non-blocking coroutine
    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}