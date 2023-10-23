package com.example.learnstupidandroid.docs.language.tests

import java.lang.reflect.Field
import java.lang.reflect.Method

object TestReflection {
    data class Student(
        private var name: String,
        private var age: Int
    ) {
        private val course: Int = 1
        private fun getStudentData() = "Name: $name, Age: $age"
    }

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