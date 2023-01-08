package com.example.plugins

import com.example.services.aboutRoute
import com.example.services.conversationRoute
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondRedirect("/about")
        }
        static("/static") {
            resources("files")
        }
        aboutRoute()
        conversationRoute()
    }
}
