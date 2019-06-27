package id.aasumitro.ktor.data.repositories

import com.google.gson.Gson
import org.jetbrains.exposed.sql.transactions.transaction
import id.aasumitro.ktor.data.models.Person
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import id.aasumitro.ktor.data.schemas.Persons

class PersonRepository : PersonContract {
    override suspend fun storePerson(person: Person): Person? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun updatePerson(person: Person): Person? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deletePersonById(id: Long): Person? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun findPersonById(id: Long): String? {
        val mPerson = Persons.select {
            Persons.id eq id
        }.first().let(ResultRow::toString)
        return Gson().toJson(mPerson)
    }

    override suspend fun getPersons(): String? {
        val mPersons = ArrayList<Person>()
        transaction {
            Persons.selectAll().forEach {
                mPersons.add(
                    Person(
                        id = it[Persons.id],
                        name = it[Persons.name],
                        email = it[Persons.email])
                )
            }
        }
        return  Gson().toJson(mPersons)
    }

}
