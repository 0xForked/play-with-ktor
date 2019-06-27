package id.aasumitro.ktor.data.schemas

import org.jetbrains.exposed.sql.*

object Persons : Table() {
    val id = long("id").primaryKey().autoIncrement()
    val name = varchar("name", 255)
    val email = varchar("email", 255)
}