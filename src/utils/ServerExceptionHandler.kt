package id.aasumitro.ktor.utils

import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

fun StatusPages.Configuration.setup() {
    exception<Throwable> { internal ->
        val status = HttpStatusCode.InternalServerError

        when {
            status.value.toString().startsWith("5") -> {
                serverLogger.error(internal.message, internal)
                call.respond(status,  Gson().toJson(InternalServerError))
            }
            else -> {
                serverLogger.warn(internal.message)
                call.respond(status, Gson().toJson(internal))
            }
        }
    }
}

val InternalServerError =
    StatusException(
        "Sorry, we encountered an error and are working on it.",
        HttpStatusCode.InternalServerError
    )

open class StatusException(
    message: String?,
    open val status: HttpStatusCode = HttpStatusCode.InternalServerError,
    cause: Throwable? = null
) : Exception(message, cause)