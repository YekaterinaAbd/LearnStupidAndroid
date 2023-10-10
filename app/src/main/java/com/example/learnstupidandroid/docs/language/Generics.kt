package com.example.learnstupidandroid.docs.language

import com.example.learnstupidandroid.common.Doc

/**
 * - Для чего нужны дженерики, приведи пример использованияя?
 * - Ковариантность, инвариантность, контрвариантность. Что такое ограничение снизу/сверху?
 *
 *
 * - Что такое 'in', 'out'? Принципы PECS
 * - Что такое star-projection (<*>)? В Java - raw type (<?>)?
 * - Можно ли определить несколько ограничений для одного дженерика ('where')?
 *
 *
 * - (*) Для чего аннотация '@JvmSupressWildcard'?
 * - (*) Что такое heap pollition? (загрязнение кучи)?
 * - (*) Приведите пример recursive generic. Для чего они нужны? (TODO)
 *
 * Type erasure (чтобы перейти к inline)
 * - Можно ли в runtime получить тип дженерика? Что такое type erasure?
 * - Для чего используется ключевое слово reified?
 */
object Generics: Doc() {

    /**
     * **Generic** - обобщенный тип
     *
     * позволяют писать код, который может работать с разными типами данных
     *
     * используется для указания типов объектов, с которыми может работать класс, интерфейс или метод
     *
     * provide type-safety and ensure that classes, interfaces, and methods could be used with different data types while still maintaining compile-time type checking
     *
     * generics часто используется в "повседневной жизни":
     * ```
     * List<String>, LiveData<Int>, Pair<String, Double>...
     * ```
     */
    override fun init() {
        docs()
        PECS()
        unboundedGenerics()
        jvmSuppressWildcards()
        heapPollution()
        typeErasure()
        listInOutExample()
    }

    /**
     * **вариантность** - определяют, какие отношения между типами разрешены при передаче аргументов
     *
     * 1. **ковариантность (covariance)** - отношение наследования или подтипа - *only type T and subtypes of T are allowed in this context*
     *
     * 2. **контрвариантность** (contravariance) - отношение супертипа -  *only type T and supertypes of T are allowed in this context*
     *
     * 3. **инвариантность** (invariance) - *only type T is allowed in this context. No supertypes or subtypes of T are allowed*
     *
     * 4. **bivariance** - *the type T, its subtypes and supertypes are allowed in this context*
     *
     *
     * ===========================================
     * - **assignment** is covariant (Kotlin, Java)
     * ```
     * val integer: Int = 1
     * val number: Number = integer
     * ```
     * - **method overriding** - return type is covariant, parameter - invariant (Kotlin, Java)
     * ```
     * interface LocalNumber {
     *     fun printNumber(number: Number): Number
     * }
     *
     * class LocalInt: LocalNumber {
     *     // return type covariant
     *     // parameter invariant
     *     override fun printNumber(number: Number): Int { return 1 }
     * }
     * ```
     * - **Generic collections** (Java) - invariant
     * ```
     * // will not compile
     * List<Parent> parents = new ArrayList<Child>()
     * ```
     *
     * - **Generic collections** (Kotlin) - IMMUTABLE: covariant, MUTABLE: invariant
     * ```
     * val numbers: List<Number> = listOf<Int>() // OK
     * val numbers: MutableList<Number> = mutableListOf<Int>() // NOT OK -> compilation error
     * ```
     * ===========================================
     *
     * to make Java collections/... covariant/contravariant: **use-site variance** (WILDCARD)
     * 1. **covariant**: <? extends T> (only read)
     * 2. **contravariant**: <? super T> (only write)
     * ```
     * // This list contains `Parent` and anything that is a subtype of `Parent`
     * List<? extends Parent> parents = new ArrayList<Child>();
     *
     * problem:
     * // This will cause a compile error.
     * okayParents.add(new Parent());
     *
     * List<Parent> - producer of generic elements, can read, cannot write
     * ```
     * ===========================================
     *
     * to make Kotlin collections/... covariant/contravariant: **declaration-site variance**
     * 1. **covariant**: out (read, producer)
     * 2. **contravariant**: in (write, consumer)
     * ```
     * val numbers: MutableList<in Number> = mutableListOf(1, 1.23)
     * numbers.add(2f)
     *
     * fun printNumbers(numbers: MutableList<out Number>) {
     *     for(number in numbers) { print(number) }
     * }
     * val outNumbers = mutableListOf(1, 1.23, 2f)
     * printNumbers(outNumbers)
     * ```
     */
    override fun docs() {}


    /**
     * **PECS** - Producer-Extends, Consumer-Super
     *
     * - Producer - предоставляет данные
     * - Consumer - принимает данные
     *
     * Java Wildcard (use-site variance):
     * 1. producer: <? extends T> - можно читать объекты T и его супертипы (ограничение сверху)
     * 2. consumer: <? super T> - можно писать объекты T и его подтипы (ограничение снизу)
     * 3. ? - ? extends Object
     *
     * Kotlin (declaration-site variance):
     * 1. producer: &lt;out T>
     * 2. consumer: &lt;in T>
     */
    private fun PECS() {}

    /**
     * Kotlin **star projection** (<*>) and Java **unbounded wildcard** (<?>)
     * - when do not know what type to specify
     * - когда мы работаем с обобщенными типами и не нужно знать конкретный тип аргумента
     *
     * ```
     * Group<in Nothing> = Group<*>
     * Group<out Any?> = Group<*>
     * ```
     *
     * **Generic constraints**
     *
     * upper bound: <T: Upper>, default: Any?
     * ```
     * fun <T : Comparable<T>> sort(list: List<T>) // only children of Comparable
     * ```
     * several upper-bounds (**where**)
     * ```
     * fun <T> sortNumbers(list: List<T>) where T: Comparable<T>, T: Number
     * ```
     * **Definitely non-nullable type** - T & Any
     * ```
     * fun load(x: T1 & Any)
     * ```
     */
    private fun unboundedGenerics() {
        val list: List<*> = listOf(1, "two", 3.0)
    }

    /**
     * **@JvmSuppressWildcards**
     *
     * аннотация, используемая в Kotlin для взаимодействия с байткодом и библиотеками Java, которые не полностью поддерживают wildcards
     *
     * Java может не понимать in/out, и тогда используется JvmSuppressWildcards, чтобы подавить их
     *
     * ```
     * fun processList(list: @JvmSuppressWildcards List<out Number>) {}
     *
     * factoryMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Factory>
     * ```
     */
    private fun jvmSuppressWildcards() {}

    /**
     * **Heap Pollution**
     *
     * Загрязнение кучи происходит когда переменная параметризованного типа ссылается на объект другого параметризованного типа
     *
     * - Обычно компилятор может идентифицировать возможное загрязнение кучи в compile time и кидает **unchecked warning**
     * - В runtime кидает **ClassCastException**
     *
     * ```
     * List<String> list = new ArrayList<String>();
     *
     * // list with raw type
     * // warning: Raw use of parameterized class 'List'
     * List rawList = list;
     *
     * // heap pollution
     * // warning: Unchecked call to 'add(E)' as a member of raw type 'java.util.List'
     * rawList.add(8);
     *
     * // ClassCastException at runtime
     * for (String str : list) {
     *    System.out.println(str);
     * }
     * ```
     *
     * Resolving Heap Pollution:
     * Avoid mixing raw types and parameterized types (avoid using raw types!!)
     */
    private fun heapPollution() {}

    /**
     * **Type Erasure**
     *
     * JMV on compile time erases the type of generic with its upper-bound
     *
     * Kotlin:
     * - unbounded: &lt;T> = Any? (Object)
     * - bounded: &lt;T: Number> = Number
     * - where: most specific
     * - collections: List&lt;T> = List<*>
     *
     * Java:
     * - upper bound: &lt;T extends Number&lt;T>> = Number
     * - lower bound: &lt;? super Number> = Number
     * - collections: List&lt;Number> = List[]
     */
    private fun typeErasure() {}

    private fun listInOutExample() {
        val inNumbers: MutableList<in Number> = mutableListOf(1, 1.23)
        inNumbers.add(2f)

        val outNumbers = mutableListOf(1, 1.23, 2f)

        fun printNumbers(numbers: MutableList<out Number>) {
            for(number in numbers) { print(number) }
        }
        printNumbers(outNumbers)
    }
}