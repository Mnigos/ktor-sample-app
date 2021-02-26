package com.example

class Question() {
    lateinit var name: String
    lateinit var answers: Array<String>

    constructor(name: String, answers: Array<String>) {
        this.name = name
        this.answers = answers
    }
}