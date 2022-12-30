package com.example.models

import java.util.concurrent.atomic.AtomicInteger

class Conversation
private constructor(val id: Int, val userQuestion: String, val chatGPTResponse: String) {
    companion object {
        private val idCounter = AtomicInteger()

        fun newQuestion(userQuestion: String, chatGPTResponse: String) =
            Conversation(idCounter.getAndIncrement(), userQuestion, chatGPTResponse)
    }
}

// val conversation = emptyList<Conversation>().toMutableList()
val conversation = mutableListOf<Conversation>(
    Conversation.newQuestion(
        "tell me about chatGPT",
        """
            I am an artificial intelligence assistant trained to assist users with a wide range of tasks and answer 
            questions to the best of my ability. My training data comes from a variety of sources, including books, 
            websites, and articles, and I am designed to be able to generate human-like text. I do not have personal 
            experiences or feelings, as I am a machine, but I am here to help you and provide information to the best 
            of my ability.
            """
    )
)