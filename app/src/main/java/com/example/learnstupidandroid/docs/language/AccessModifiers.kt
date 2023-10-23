package com.example.learnstupidandroid.docs.language

import com.example.learnstupidandroid.common.Doc
import com.example.learnstupidandroid.docs.language.tests.TestReflection

/**
 * - Может назвать все модификаторы видимости и рассказать про каждый (можно без internal и package private)
 * - Какой модификатор видимости по умолчанию в Kotlin? Java?
 * - Как реализован internal и видно ли его из Java? Как сделать чтобы internal нельзя было вызвать из Java?
 * - Разница package private и internal
 * - Можно ли получить доступ к private не в калссе, а в внутри экземпляра класса?
 * - Можно ли получить доступ к приватный членам класса внутри другого класса?
 **/
object AccessModifiers : Doc() {

    override fun init() {
        docs()
        LibraryClass()
        reflection()
        TestReflection
    }

    /**
     * Kotlin
     * - private: visible inside the file/class containing the declaration
     * - protected: visible inside same class and subclasses (NO top level declaration)
     * - internal: visible inside the same module
     * - public (default): visible everywhere
     *
     * Java
     * - private: visible only inside the class (NO top level classes)
     * - default (package-private): visible only in the same package
     * - protected: in the same package or subclasses in different packages (NO top level)
     * - public: everywhere
     *
     * **In Kotlin, there’s no exact substitute for the package-private(default) modifier from Java.**
     *
     * Kotlin to Java
     * - private -> private
     * - protected -> protected
     * - internal -> public
     * - public -> public
     */
    override fun docs() {}

    /**
     * Kotlin INTERNAL to Java
     *
     * **internal becomes public in Java**
     *
     * Problem: we have library written in Kotlin with some internal members.
     * When we use this library in Java, internal members become public and we can access them.
     *
     * **Workaround: Use [@JvmSynthetic]**
     *
     * [@JvmSynthetic] is used for this purpose, the members annotated with [@JvmSynthetic], cannot be accessed
     * in compile time, but already compiled Java code will be able to access such target.
     *
     */
    class LibraryClass {

        //Not accessed by Java
        @set: JvmSynthetic
        @get: JvmSynthetic
        internal var count: Int = 0

        //Not accessed by Java
        @JvmSynthetic
        internal fun updateCount() {
            count += 1
        }

        //Accessed by Java
        fun doSomethingExternally() {}
    }

    /**
     * We can get private members using reflection with
     * - privateField.isAccessible = true
     *
     * **Java reflection**
     *
     * To access private fields use
     * ```
     * privateField = Someclass::class.java.getDeclaredField("field")
     * provateFiield.isAccessable = true
     * ```
     */
    private fun reflection() {
        TestReflection
    }
}