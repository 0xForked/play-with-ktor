package id.aasumitro.ktor

import id.aasumitro.ktor.data.KtorDatabase

fun main(args: Array<String>) {
    KtorDatabase()
    io.ktor.server.netty.EngineMain.main(args)
}



