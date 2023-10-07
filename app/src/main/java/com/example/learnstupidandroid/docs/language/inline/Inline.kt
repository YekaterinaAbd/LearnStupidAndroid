package com.example.learnstupidandroid.docs.language.inline

import com.example.learnstupidandroid.common.Doc

/**
 * - Чем отличается inline функция от обычной функции?
 * - Когда стоит делать функцию inline? Случаи и примеры использования
 * - 'crossinline' и 'noinline'. В чем их отличие и для чего они нужны?
 * - Как работает ключевое слово 'const' (тоже inline)?
 * - inline class (value class). Случаи и примеры использования
 * - (*) Что происходит с inline функцией после компиляции? Можно ли через рефлексию получить доступ к inline функции?
 */
object Inline : Doc() {

    /**
     * inline используется для встраивания функций.
     * В основном используется с lambda функциями для повышения производительности.
     *
     * В обычных функциях lambda выражения компилируются в анонимные классы. Тоесть создается дополнительный класс.
     *
     * Если использовать inline, то доп класс не создается, код просто вставится в место вызова.
     * Сама inline функция тоже встроится в место вызова.
     *
     * inline функции должны бысть маленькими, 2-3 строчки кода, потому что используют **РЕФЛЕКСИЮ**.
     * While reflection can be useful, it significantly impacts performance.
     *
     * После компиляции, код inline функции встраивается в каждое место ее вызова.
     * Cама функция, как ее вызовы, исчезают, и вместо них в байт-коде программы появляется код, который был внутри функции
     */
    override fun init() {
        docs()
        reified()
        ValueClass
    }

    /**
     * **inline function**: [inlineFun]
     * ```
     * inline fun function(lambda: () -> Unit) {}
     * ```
     *
     * **noinline** - если не хотим, чтобы lambda была встроена: [noInlineFun]
     * ```
     * inline fun function(lambda: () -> Unit, noinline noInlineLambda: () -> Unit) {}
     * ```
     *
     * **crossinline**: [crossInlineFun]
     *
     * разница inline и noninline параметров в том, что inline можно вызывать только внутри inline функции,
     * тогда как с noninline никаких ограничений нет
     *
     * когда внутри inline функции есть другая функция, можно использовать **crossinline**,
     * тогда lambda будет и встроена, и можно будет передать во вторую функцию
     *
     * В таких случаях, нелокальное управление потоком выполнения (non-local return) также запрещено в лямбдах
     * ```
     * private inline fun highOrderFun(crossinline lambda: () -> Unit) {
     *     lambda()
     *     simpleFun {
     *         lambda()
     *     }
     * }
     * ```
     *
     * **return**
     *
     * in simple function we cannot invoke *return* in lambda function.
     * we should use label (return@simpleFun), to exit only lambda function
     * ```
     * simpleFun {
     *     return@simpleFun
     * }
     * ```
     * in inline functions we can use **return** to exit the whole inline function (non-local return)
     *
     * example [hasZeros]: наример используется в циклах, которые являются inline функциями
     * ```
     * list.forEach {
     *     if (it == 0) return true //return from full function
     * }
     * ```
     */
    override fun docs() {
        simpleFun {
            println("hello")
            return@simpleFun
        }
        inlineFun {
            println("hello")
            return
        }
    }

    /**
     * **reified** (параметры вещественного типа)
     *
     * - can only be used in inline
     * - используется чтобы получить доступ к типу, переданному в качестве параметра
     * - может использовать рефлексию
     *
     * **type erasure**
     *
     * когда используем обычную функцию для обобщенного типа (generics), то информация в самом типе стирается (type erasure) при компиляции
     *
     * ```
     * fun <T> check(value: T) {
     *     val isString = value is String // произошло стирание
     * }
     * ```
     * в случае с reified компилятор определяет тип переданного параметра и генерирует байт-код, который ссылается на конкретный класс
     *
     * например: вызов по типу **myVar is T** becomes **myVar is String** in the bytecode (if the type argument is String).
     *
     * reified функции невозможно вызывать из Java
     */

    private fun reified() {
        reifiedFun("hello")
    }

    private inline fun <reified T> reifiedFun(value: T) {
        val clazz = T::class.java
        when (T::class) {
            Int::class -> 1 as T
            String::class -> "string" as T
        }
    }

    private fun simpleFun(lambda: () -> Unit) {
        lambda()
    }

    private inline fun inlineFun(lambda: () -> Unit) {
        lambda()
    }

    private inline fun noInlineFun(lambda: () -> Unit, noinline noInlineLambda: () -> Unit) {
        lambda()
        simpleFun {
            noInlineLambda()
        }
    }

    private inline fun crossInlineFun(crossinline lambda: () -> Unit) {
        simpleFun {
            lambda()
        }
    }

    private fun hasZeros(): Boolean {
        val list = listOf(1, 2, 3, 4, 0, 5)
        //inline fun
        list.forEach {
            if (it == 0) return true //return from hasZeros
        }
        return false
    }
}