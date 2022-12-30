package com.example.services

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.aboutRoute() {
    route(path="/about") {
        get {
            // Redirect and show about chatGPT page
            call.respondRedirect("/static/aboutChatGPTandKtor.html")
        }
    }
}