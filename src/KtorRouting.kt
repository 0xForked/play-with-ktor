package id.aasumitro.ktor

import id.aasumitro.ktor.presenters.PersonPresenter
import id.aasumitro.ktor.routes.person
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.setup(
   personPresenter: PersonPresenter
) {

    route("/") {
        get {
            call.respondText("Hello World!")
        }
    }

    person(personPresenter)
}