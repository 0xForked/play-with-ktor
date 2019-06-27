package id.aasumitro.ktor.presenters

import id.aasumitro.ktor.data.repositories.PersonRepository

class PersonPresenter(
    private val personRepository: PersonRepository
) {

    suspend fun getPersons() = personRepository.getPersons()

    suspend fun getPerson(id: Long) = personRepository.findPersonById(id)

}