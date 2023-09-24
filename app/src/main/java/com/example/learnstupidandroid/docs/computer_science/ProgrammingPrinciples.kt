package com.example.learnstupidandroid.docs.computer_science

import com.example.learnstupidandroid.common.Doc

/**
 * - DRY
 * - KISS
 *
 *
 * - SOLID
 * - Уметь распознавать на ревью нарушения принципов SOLID (или других принципов)
 * - Знать другие принципы ООП, помимо SOLID
 * - GRASP


 * - YAGNI


 * - Separation of Concerns (SoC)
 * - Avoid Premature Optimization
 * - Law of Demeter
 * - https://www.geeksforgeeks.org/7-common-programming-principles-that-every-developer-must-follow/
 */

object ProgrammingPrinciples : Doc() {

    override fun init() {
        docs()
        solid()
    }

    /**
     * **DRY**
     *
     * - Don't repeat yourself


     * **KISS**
     * - Keep It Simple, Stupid
     * - Не придумывайте к задаче более сложного решения, чем ей требуется.

     * **YAGNI**
     * - You Aren’t Gonna Need It
     * - Если пишете код, то будьте уверены, что он вам понадобится. Не пишите код, если думаете, что он пригодится позже.
     **/
    override fun docs() {
    }

    /**
     * **SOLID**

     * **S**
     *
     * **Single-responsibility principle /Принцип единственной ответственности**
    - Каждый объект, класс и метод должны отвечать только за что-то одно.
    - Модуль должен отвечать за одного и только за одного пользователя или заинтересованное лицо

     * **O**
     *
     * **Open–closed principle / Принцип открытости-закрытости**
    - Программные объекты должны быть открыты для расширения, но закрыты для модификации.
    - Нельзя переопределять методы или классы, просто добавляя дополнительные функции по мере необходимости.

     * **L**
     *
     * **Liskov substitution principle / Принцип подстановки Лисков**
    - Дочерний класс должен следовать принципам родительского класса и не изменять их

     * **I**
     *
     * **Interface segregation principle / Принцип разделения интерфейсов**
    - Объекты не должны зависеть от интерфейсов, которые они не используют

     * **D**
     *
     * **Dependency inversion principle / Принцип инверсии зависимостей**
    - Сущности должны зависеть от абстракций, а не от чего-то конкретного
    - Модули верхнего уровня не должны зависеть от модулей нижнего уровня.
    - И те, и другие должны зависеть от абстракций. Абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций.

     **/
    private fun solid() {}
}

