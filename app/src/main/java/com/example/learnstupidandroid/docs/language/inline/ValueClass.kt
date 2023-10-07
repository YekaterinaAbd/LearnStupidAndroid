package com.example.learnstupidandroid.docs.language.inline

import com.example.learnstupidandroid.common.Doc

object ValueClass : Doc() {

    /**
     * **value (inline, встроенный) class**
     *
     * when we need to create a wrapper around primitive type, the performance is bad,
     * as primitives are optimized much better in runtime than wrappers.
     *
     * inline class does not have identity and can only store value.
     *
     * data is inlined where it’s used, and object instantiation is skipped in the compiled code.
     * ```
     * @JvmInline
     * value class Password(val s: String)
     * ```
     *
     * - data of value class is inlined into its usages (like inline functions)
     * - can have a single property (only 1 value in primary constructor)
     * - value cannot be changed
     * - do not participate in class hierarchy (cannot be subclasses or extended)
     * - no lateinit or delegated properties
     *
     * **representation**
     *
     * встроенные классы вводят действительно новый тип, в отличие от **псевдонимов типов**,
     * которые вводят только альтернативное имя для существующего типа.
     *
     * экземпляры value class могут быть представлены во время выполнения либо как обертки, либо как базовый тип.
     *
     * value class оборачиваются, когда они используются в качестве другого типа:
     * ```
     * fun asInline(v: Value class) {} // не оборачивается
     * fun <T> asGeneric(x: T) {} // оборачивается
     * fun asNullable(i: Foo?) {} // оборачивается
     * ```
     */
    override fun init() {
        docs()
    }

    /**
     * **members**
     *
     * value classes can
     * - have properties and functions
     * - have secondary constructors
     * - have init blocks
     * - inherit interfaces
     *
     * example: [FullName]
     */
    override fun docs() {
        val password = Password("helloworld")

        val name = FullName("John")
        val fullName = FullName("John", "Smith")

        name.length
        name.greet()
        name.print()
    }
}

@JvmInline
value class Password(val s: String)

@JvmInline
value class FullName(val name: String) : Printable {

    /**init block**/
    init {
        require(name.isNotEmpty())
    }

    /** constructor **/
    constructor(name: String, surname: String) : this("$name $surname")

//    constructor with body only since kotlin 1.9
//    constructor(name: String, surname: String, lastName: String) : this("$name $surname $lastName") {
//        require(name.isNotEmpty() && surname.isNotEmpty() && lastName.isNotEmpty())
//    }

    /** inheritance from interface **/
    override fun print() {
        println(name)
    }

    /** property
     *
     * property getter is called as a static method
     **/
    val length
        get() = name.length

    /** function
     *
     * function is called as a static method
     **/
    fun greet() = "Hello $name"

}

interface Printable {
    fun print()
}



