package com.example.learnstupidandroid.docs.language

import com.example.learnstupidandroid.common.Doc
import java.lang.reflect.Field
import java.lang.reflect.Method

object AccessModifiers : Doc() {

    override fun init() {
        docs()
        LibraryClass()
        reflection()
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
     * - protected: in the same package or subclasses in different packages
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
     */
    private fun reflection() {
        // See class Student and object Reflection
    }
}

data class Student(
    private var name: String,
    private var age: Int
) {
    private val course: Int = 1
    private fun getStudentData() = "Name: $name, Age: $age"
}

/**Java reflection**/
object Reflection {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            // Create Student object
            val student = Student("Kapil", 23)

            /**
             * output:
             *
             * Name of Student: Kapil
             */
            fun printPrivateField() {
                // Create Field object
                val privateField: Field = Student::class.java.getDeclaredField("name")
                // Set the accessibility as true (makes private fields accessible, name field is private)
                privateField.isAccessible = true
                // Store the value of private field in variable
                val name = privateField.get(student)
                println("Name of Student: $name")
            }

            /**
             * output:
             *
             * Name: Kapil, Age: 23
             */
            fun printPrivateMethod() {
                // Create Method object
                val privateMethod: Method = Student::class.java.getDeclaredMethod("getStudentData")
                // Set the accessibility as true (getStudentData method is private)
                privateMethod.isAccessible = true
                // Store the returned value of private methods in variable
                val getStudentData = privateMethod.invoke(student)
                println("$getStudentData")
            }

            /**
             * output:
             *
             * - name Kapil
             * - age 23
             * - course 1
             */
            fun printAllFields() {
                val declaredFields = Student::class.java.declaredFields
                for (field in declaredFields) {
                    field.isAccessible = true
                    println("${field.name} ${field.get(student)}")
                }
            }

            /**
             * output:
             *
             * equals, toString, hashCode, copy, component1, component2, copy$default, getStudentData
             */
            fun printAllMethods() {
                val declaredMethods = Student::class.java.declaredMethods
                for (method in declaredMethods) {
                    print("${method.name}, ")
                }
            }

            printPrivateField()
            printPrivateMethod()
            printAllFields()
            printAllMethods()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}