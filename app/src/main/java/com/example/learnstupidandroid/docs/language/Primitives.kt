package com.example.learnstupidandroid.docs.language

import com.example.learnstupidandroid.common.Doc

/**
 * - Есть ли в Kotlin примитивы?
 * - Можно ли создать пременную примитивного типа? (НЕТ)
 * - Зачем нужны объекты-обёртки? В каком случае компилятор подставит обёртку вместо примитива
 * - Что такое (un)wrapping
 */
object Primitives: Doc() {

    override fun init() {
        docs()

        integers()
    }

    /**
     * В Котлине все обернуто в объект и как таковых примитивов нет.
     *
     * **Numbers, characters and booleans** can be represented as primitive values at **runtime** –
     * but to the user they look like ordinary classes
     *
     * [Number], [Char], [Boolean]
     *
     * **NOTE**: in JVM basic types represent as primitives,
     * EXCEPT nullable types (Int?, Double?) - they are boxed in Java classes Integer, Double...
     *
     * Nullable references to the same number can refer to **different objects**
     */
    override fun docs() {}

    /**
     * Number: [Byte], [Short], [Int], [Long]
     * - When initialized without specified type, compiler infers type automatically starting with Int
     *
     * Floating point: [Float], [Double] (more than float)
     *
     * - Compiler infers Double type
     */
    private fun integers() {}
}