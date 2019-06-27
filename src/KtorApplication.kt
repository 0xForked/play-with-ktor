package id.aasumitro.ktor

import data.database.KtorDatabase

fun main(args: Array<String>) {
    KtorDatabase()
    io.ktor.server.netty.EngineMain.main(args)
}



