package com.example.services

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.conversationRoute() {
    route(path = "/conversation") {
        get {
            // Redirect and show about chatGPT page
            call.respondRedirect("/static/aboutChatGPTandKtor.html")
        }
        get("new") {
            // Show a page with fields for creating a new article
        }
        post {
            // Save an article
        }
        get("{id}") {
            // Show an article with a specific id
        }
        get("{id}/edit") {
            // Show a page with fields for editing an article
        }
        post("{id}") {
            // Update or delete an article
        }
    }
}