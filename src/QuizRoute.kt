package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*

fun Routing.quiz() {
    route("/quiz") {
        get("/questions") {
            val questions: Array<Question> = arrayOf(
                Question("Do you like hamburgers?", arrayOf("yes", "no")),
                Question("Have you ever been in Poland?", arrayOf("yes", "no")),
                Question("Do you learn javascript", arrayOf("yes", "no")),
            )
        }
    }
}
