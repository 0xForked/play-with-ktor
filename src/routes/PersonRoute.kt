package id.aasumitro.ktor.routes

import id.aasumitro.ktor.presenters.PersonPresenter
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.person(
    personPresenter: PersonPresenter
) = route("persons") {

    get {
        val mPersons = personPresenter.getPersons()
        call.respondText(mPersons as String)
    }

    get("/{personId}") {
        val mPersonId = call.parameters["personId"]
        val mPerson = personPresenter.getPerson(mPersonId?.toLong() as Long)
        call.respondText(mPerson as String)
    }

}