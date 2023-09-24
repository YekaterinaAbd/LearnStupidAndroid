package com.example.learnstupidandroid.docs.computerScience.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object PropertiesDelegates {

    /**
     * - val - provide getValue(thisRef: Owner, property: KProperty<*>)
     * - var - provide getValue(...) and setValue(thisRef: Owner, property: KProperty<*>, value: Any?)
     *
     * functions must be operator fun
     */

    fun init() {
        ClassDelegate()
        objectDelegate()

        //examples
        usingClassDelegate()
        usingObjectDelegate()
    }

    /**
     * Create delegate using class
     */
    class ClassDelegate {

        /**
         * @param propertiesDelegates the object you read value from
         * @param property [KProperty]<*> - holds the description of value
         * @param value value being assigned
         */
        operator fun setValue(propertiesDelegates: Any, property: KProperty<*>, value: String) {
            //when the value is set, print it properties
            println("$propertiesDelegates ${property.name} $value")
        }

        /**
         * @param propertiesDelegates the object you read value from
         * @param property [KProperty]<*> - holds the description of value
         */
        operator fun getValue(propertiesDelegates: Any, property: KProperty<*>): String {
            return "$propertiesDelegates ${property.name}"
        }
    }

    /**
     * **Create delegate without new classes using object**
     *
     * use interface [ReadOnlyProperty], [ReadWriteProperty] (can use ReadWriteProperty with val)
     */
    private fun objectDelegate(s: String = "SOMETHING"): ReadWriteProperty<Any?, String> =
        object : ReadWriteProperty<Any?, String> {
            var curValue = s
            override fun getValue(thisRef: Any?, property: KProperty<*>) = curValue
            override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
                curValue = value
            }
        }


    /**
     * Examples
     */
    private var classDelegate: String by ClassDelegate()
    private var varFunDelegate: String by objectDelegate()
    private val valFunDelegate: String by objectDelegate()

    /**
     * Example class delegate
     */
    private fun usingClassDelegate() {
        println(classDelegate)
        classDelegate = "NEW VALUE"
        println(classDelegate)
    }

    /**
     * Example object delegate
     */
    private fun usingObjectDelegate() {
        println(varFunDelegate)
        varFunDelegate = "SOMETHING NEW"
        println(varFunDelegate)

        // val cannot be reassigned error
        // valFunDelegate = "SOMETHING NEW"
    }
}