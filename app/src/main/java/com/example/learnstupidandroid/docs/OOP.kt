package com.example.learnstupidandroid.docs

import com.example.learnstupidandroid.common.Doc

/**
    - Знать основную идею ООП
    - Знать отличия интерфейса от абстрактного класса
    - Хорошо понимать икапсуляцию и наследование
    - Понимать все принципы ООП
    - Знать зачем нужен каждый из принципов
    - Знать плюсы и минусы каждого принципа
    - Понимать композицию
    - Иметь глубокие знания ООП
    - В ревью предлагать оптимальные решения с помощью принципов ООП
    - Понимать связь между принципами ООП
    - Знать агрегирование
    - Знать более одной парадигмы программирования (Императивная, функциональная, декларативная)
 */

object OOP: Doc() {

    override fun init() {
        docs()
    }

    override fun docs() {
    /**
        List of OOP concepts in Java:

        1. Abstraction
            hide internal implementation details using abstract classes or interfaces
            1. Abstract class
                cannot be instantiated
                partial abstraction (0-100%)
                java: defined with the abstract keyword
            2. Interface
                total abstraction (100%)
                can only have static, final, and public fields and abstract methods

        2. Encapsulation
            protect the data stored in a class from system-wide access
            get() set()

        3. Inheritance
            makes it possible to create a child class that inherits the fields and methods of the parent class
            extends keyword
            implements the DRY programming principle

        4. Polymorphism
            two forms: method overloading and method overriding
            static polymorphism - overloading // fun doSmth(), fun soSmth(param: Param)
            dynamic polymorphism - overriding // child class overrides a method of its parent

        5. Association
            the act of establishing a relationship between two unrelated classes
            separate classes are associated through their objects
            classes are unrelated, each can exist without the other one
            one-to-one, one-to-many, many-to-one, or many-to-many relationship

            6. Aggregation
                one-way (HAS-A) relationship
                weak association
                classes can exist independently
                objects' life cycles are not bound to each other

            7. Composition
                PART-OF relationship
                strong association
                both of the classes are dependent on each other
                one class is part of another class
                when the main object dies, all the objects associated with that object also die
         */
    }
}