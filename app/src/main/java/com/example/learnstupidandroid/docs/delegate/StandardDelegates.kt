package com.example.learnstupidandroid.docs.delegate

object StandardDelegates {

    fun init() {
        lazyProperty()
    }

    private fun lazyProperty() {
        val lazyString: String by lazy {
            println("initialized")
            "Something"
        }
    }
}