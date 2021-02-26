package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.random.Random

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        post("/") {
            val name = call.receive<String>()
            call.respondText("HELLO $name", contentType = ContentType.Text.Plain)
        }

        post("/loss") {
            val array = call.receive<Array<String>>()
            val randomItem =  array[Random.nextInt(0, array.size)]

            call.respondText("Random array element $randomItem", contentType = ContentType.Text.Plain)
        }
    }
}
