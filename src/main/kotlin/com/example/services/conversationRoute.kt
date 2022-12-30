package com.example.services

import com.example.models.Conversation
import com.example.models.conversations
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.conversationRoute() {
    route(path = "/conversations") {
        get {
            // Show a list of conversation
            call.respond(
                FreeMarkerContent(
                    template = "indexConversation.ftl",
                    model = mapOf("conversations" to conversations)
                )
            )
        }
        get("new") {
            // Show a page with fields for creating a new conversation
            call.respond(
                FreeMarkerContent(
                    template = "newConversation.ftl",
                    model = null
                )
            )
        }
        post {
            // Save a conversation
            val formParameters = call.receiveParameters()
            val userQuestion = formParameters.getOrFail("userQuestion")
            val chatGPTResponse = formParameters.getOrFail("chatGPTResponse")
            val newConversation = Conversation.newQuestion(userQuestion, chatGPTResponse)
            conversations.add(newConversation)
            call.respondRedirect("/conversations/${newConversation.id}")
        }
        get("{id}") {
            // Show a conversation with a specific id
            val id = call.parameters.getOrFail("id").toInt()
            call.respond(
                FreeMarkerContent(
                    template = "showConversation.ftl",
                    model = mapOf("conversation" to conversations.find { it.id == id })
                )
            )
        }
        get("{id}/edit") {
            // Show a page with fields for editing an article
        }
        post("{id}") {
            // Update or delete an article
        }
    }
}