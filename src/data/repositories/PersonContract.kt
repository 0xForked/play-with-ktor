package id.aasumitro.ktor.data.repositories

import id.aasumitro.ktor.data.models.Person

interface PersonContract {

    suspend fun storePerson(person: Person): Person?
    suspend fun updatePerson(person: Person): Person?
    suspend fun deletePersonById(id: Long): Person?
    suspend fun findPersonById(id: Long): String?
    suspend fun getPersons(): String?

}
