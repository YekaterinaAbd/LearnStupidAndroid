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
object Kotlin : Doc() {

    /**
     * - Data class vs Class vs Open class +
     * - Nested and Inner Class +
     * - Enum, Sealed class, sealed interface +
     *
     * - Functional Interfaces +
     * - Type aliases +
     *
     * - Object, companion object
     * - Anonymous object
     *
     * - val vs var vs const, lateinit +
     * - let/run/with/also/apply
     *
     * - Infix
     * - Invoke
     *
     * - Destructuring declarations +
     *
     * - Serializable, Parcelable
     */
    override fun init() {
        docs()
    }

    override fun docs() {
        destructingDeclaration()
        properties()
    }

    /**
     * **destructing declaration**
     *
     * destructing declaration creates multiple variables at once
     * ```
     * val (name, age) = person
     *
     * // compiled to:
     * val name = person.component1()
     * val age = person.component2()
     * ```
     * maps:
     * ```
     * for((key, value) in map) {...}
     * ```
     * to skip the componentI can use underscode:
     * componentN function is not called for skipped elements
     * ```
     * val (_, status) = getResult()
     * ```
     *
     */
    private fun destructingDeclaration() {}

    /**
     * **const** - compile-time constants, read-only
     * - top-level, a part of object or companion-object
     * - only primitives or String
     *
     * - const is inlined, and the reference will be replaced with actual value
     * - the field will not be removed, and can be accessed using **reflection**
     *
     * **var** - mutable
     *
     * **val** - immutable
     *
     * **custom setter** called every time you assign a value to the property, except its initialization
     *
     * **lateinit**
     * - only var
     * - inside class body, top-level property, local variable
     * - must be non-nullable
     * - must be not primitive type
     * - accessing before initialization throws exception
     */
    private fun properties() {
        class MutableRectangle(val width: Int, var height: Int) {
            var area: Int
                get() = width * height
                set(value) {
                    height = value / width
                }
            var isSquare: Boolean = width == height
                private set

            // backing field
            var counter = 0
                set(value) {
                    if (value > 0) {
                        field = value //field = counter
                    }
                }
        }

    }
}