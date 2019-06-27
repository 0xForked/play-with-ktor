package data.database

import id.aasumitro.ktor.data.schemas.Persons
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create


class KtorDatabase {

    init {
        val url = "jdbc:mysql://localhost:3306/ktor"
        val driver = "com.mysql.jdbc.Driver"
        val user = "root"
        val password = ""
        Database.connect(url, driver, user, password)
        transaction {
            create(Persons)
        }
    }

}
