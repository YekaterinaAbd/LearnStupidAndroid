package com.example.learnstupidandroid.docs.language

import com.example.learnstupidandroid.common.Doc

/**
 * - Знать синтаксис
 * - Соблюдать code style
 * - Collections
 * - Data class vs Class vs Open class
 * - Extension
 * - Object, companion object
 * - Sealed class
 * - val vs var vs const
 * - FP
 * - let/run/with/also/apply
 * - Inline/noninline/crossinline
 * - DSL
 * - Infix
 * - Invoke
 */
object Functions : Doc() {

    /**
     * - scope fuctions: let/run/with/also/apply +
     * - extension functions
     * - Infix
     * - Invoke
     *
     * - Serializable, Parcelable
     */
    override fun init() {
        docs()
    }

    override fun docs() {
        scopeFunctions()
    }

    /**
     * **scope functions**
     * - create a temporary scope
     * - we can access object without its name
     * - make code more concise and readable
     *
     * ===========================================
     *
     * **let**
     * - context object is available as an argument (it).
     * - return value is the lambda result.
     * ```
     * public inline fun <T, R> T.let(block: (T) -> R): R {
     *     return block(this)
     * }
     * ```
     * - когда вам нужно выполнить операции на объекте и вернуть результат
     * - execute a code block containing non-null values
     * ```
     * getNullablePerson()?.let {
     *     // only executed when not-null
     *     promote(it)
     * }
     * ```
     * - introduce local variables with a limited scope
     * ```
     * getPersonDao().let { dao ->
     *     // scope of dao variable is limited to this block
     *     dao.insert(person)
     * }
     * ```
     * ===========================================
     *
     * **with**
     * - The context object is available as a receiver (this).
     * - The return value is the lambda result.
     * ```
     * public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
     *     return receiver.block()
     * }
     * ```
     * - when you don't need to use the returned result
     * - only on non-nullable receivers
     * - **with this object, do the following**
     *
     * ===========================================
     *
     * **run**
     * - The context object is available as a receiver (this).
     * - The return value is the lambda result.
     * ```
     * public inline fun <T, R> T.run(block: T.() -> R): R {
     *     return block()
     * }
     * ```
     * does the same as with but it is implemented as an extension function
     * - предпочтительнее когда меняешь состояние, а let когда не меняешь
     * - useful when lambda both initializes objects and computes the return value
     *```
     * val result = service.run {
     *     port = 8080
     *     query(prepareRequest() + " to port $port")
     * }
     * ```
     * **run as non-extension fun**
     * - has no context object, but it still returns the lambda result
     * - lets you execute a block of several statements where an expression is required
     * - **run the code block and compute the result**
     * ```
     * val inserted: Boolean = run {
     *     val person: Person = getPerson()
     *     val personDao: PersonDao = getPersonDao()
     *     personDao.insert(person)
     * }
     * ```
     * ===========================================
     *
     * **apply**
     * - The context object is available as a receiver (this).
     * - The return value is the object itself.
     * ```
     * public inline fun <T> T.apply(block: T.() -> Unit): T {
     *     block()
     *     return this
     * }
     * ```
     * - object configuration
     * - **apply the following assignments to the object**
     * - когда нужно настроить объект и вернуть его же
     *
     * ===========================================
     *
     * **also**
     * - The context object is available as an argument (it).
     * - The return value is the object itself.
     * ```
     * public inline fun <T> T.also(block: (T) -> Unit): T {
     *     block(this)
     *     return this
     * }
     * ```
     * - if your block does not access its receiver parameter at all, or if it does not mutate its receiver parameter
     * - **and also do the following with the object**
     * - для выполнения операций на объекте, не изменяя его состояния
     *```
     * val numbers = mutableListOf("one", "two", "three")
     * numbers
     *     .also { println("The list elements before adding new one: $it") }
     *     .add("four")
     * ```
     */
    private fun scopeFunctions() {
        val something = "something"
        //lambda function return
        val something1: String = something.let {
            it
        }
        with(something) {

        }
        //lambda function return
        val something2: String = something.run {
            this
        }
        //lambda function return
        val inserted: Boolean = run {
            true
        }
        //returns object itself
        val something3: String = something.apply {

        }
        //returns object itself
        val something4: String = something.also {

        }
    }

    @JvmStatic
    fun main(args: Array<String>) {

    }
}