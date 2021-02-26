package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.random.Random

fun Routing.root() {
    get("/") {
        call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
    }

    post("/") {
        val name = call.receive<String>()
        call.respondText("HELLO $name", contentType = ContentType.Text.Plain)
    }
}

fun Routing.rnd() {
    get("/rnd") {
        val array = List(Random.nextInt(1, 20)) { Random.nextInt(0, 100) }

        call.respondText("Your random array: $array", contentType = ContentType.Text.Plain)
    }
}

fun Routing.loss() {
    post("/loss") {
        val array = call.receive<Array<String>>()
        val randomItem = array[Random.nextInt(0, array.size)]

        call.respondText("Random array element $randomItem", contentType = ContentType.Text.Plain)
    }
}