package com.example.services

import com.aallam.openai.api.completion.CompletionRequest
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
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

            // Aallam OpenAI Completion API
            val apiKey = System.getenv("OPENAI_API_KEY")
            val openAI = OpenAI(apiKey)
            val davinci = openAI.model(modelId = ModelId(id = "text-davinci-003"))
            val completionRequest = CompletionRequest(
                model = davinci.id,
                prompt = userQuestion,
                temperature = 0.6,
                maxTokens = 2048
            )
            val chatGPTResponse = openAI.completion(completionRequest).choices.first().text

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
        post(path = "{id}") {
            // delete a conversation with a specific id
            val id = call.parameters.getOrFail("id").toInt()
            conversations.removeIf { it.id == id }
            call.respondRedirect("/conversations")
        }
    }
}