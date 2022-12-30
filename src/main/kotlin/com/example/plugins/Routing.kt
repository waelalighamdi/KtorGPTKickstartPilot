package com.example.plugins

import com.example.services.conversationRoute
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
//            call.respondText("Hello World!")
            call.respondRedirect("/conversation")
        }
        static("/static") {
            resources("files")
        }
        conversationRoute()
    }
}
