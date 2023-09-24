package com.example.learnstupidandroid.docs.computer_science.delegate

import com.example.learnstupidandroid.common.Doc

/**
    - Для чего нужны делегаты?
    - Какие типы делеаготов есть? (На классы, на поля)
    - Как работает делегат для класса?
    - Какие стандартные делегаты знаешь?
    - Как сделать свой делегат? Как это сделать с чужим типом? (provide delegate, getValue, setValue)
    - Отличие immutable и mutable делегатов
    - Отличие делегата 'by notNull' от 'lateinit' и 'by lazy {}'. Проблемы 'lateinit'
 */

object Delegates: Doc() {

    override fun init() {
        StandardDelegates.init()
        OverrideClassDelegates.init()
        PropertiesDelegates.init()
    }

    override fun docs() {

    }
}