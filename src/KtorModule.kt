package id.aasumitro.ktor

import io.ktor.application.Application
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.auth.*
import io.ktor.gson.*
import io.ktor.features.*
import id.aasumitro.ktor.data.repositories.PersonContract
import id.aasumitro.ktor.data.repositories.PersonRepository
import id.aasumitro.ktor.presenters.PersonPresenter
import id.aasumitro.ktor.utils.setup
import org.slf4j.event.Level


fun Application.module() {

    val mPersonRepository: PersonContract = PersonRepository()
    val mPersonPresenter = PersonPresenter(mPersonRepository as PersonRepository)

    install(CallLogging) { level = Level.INFO }

    install(Authentication) { }

    install(ContentNegotiation) { gson { } }

    install(Routing) { setup(mPersonPresenter) }

    install(StatusPages) { setup() }

}

