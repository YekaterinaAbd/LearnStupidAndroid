package com.example.learnstupidandroid.docs.language.tests

object TestClass {
    class Person(var name: String, var surname: String)
    data class DataPerson(var name: String, var surname: String)

    private inline fun <reified T> T.printFields() {
        val clazz = T::class.java
        val className = clazz.simpleName
        println(className)
        val fields = clazz.declaredFields
        print("fields: ")
        fields.forEach { print("${it.name} ") }
        println()

        val methods = clazz.declaredMethods
        print("methods: ")
        methods.forEach { print("${it.name} ") }
        println()
        println()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val person = Person("Person", "Surname")
        val person2 = Person("Person", "Surname")
        val student = DataPerson("DataPerson", "Surname")
        val student2 = DataPerson("DataPerson", "Surname")

        //Person
        //fields: name
        //methods: getName setName
        person.printFields()

        //DataPerson
        //fields: name
        //methods: getName equals toString hashCode setName copy component1 copy$default
        student.printFields()

        //false because no equals() and hashcode() provided
        println(person == person2)
        // true because data class
        println(student == student2)

        // destructing declarations
        // error because class does not have companionN functions
        // val (name, surname) = person
        // companionN functions make it working
        val (namedata, surnamedata) = student

    }
}