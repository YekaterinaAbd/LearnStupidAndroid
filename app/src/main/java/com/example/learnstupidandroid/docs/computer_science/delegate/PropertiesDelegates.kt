package com.example.learnstupidandroid.docs.computer_science.delegate

import android.util.Log
import kotlin.properties.ReadWriteProperty
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object PropertiesDelegates {

    /**
     * - val - provide getValue(thisRef: Owner, property: KProperty<*>)
     * - var - provide getValue(...) and setValue(thisRef: Owner, property: KProperty<*>, value: Any?)
     *
     * functions must be operator fun
     */
    private var delegate: String by ClassDelegate()
    private var funDelegate: String by objectDelegate()
    private val valFunDelegate: String by objectDelegate()

    fun init() {
        ClassDelegate()
        objectDelegate()

        usingClassDelegate()
        usingObjectDelegate()
    }

    class ClassDelegate {

        /**
         * @param propertiesDelegates the object you read value from
         * @param property [KProperty]<*> - holds the description of value
         * @param value value being assigned
         */
        operator fun setValue(propertiesDelegates: Any, property: KProperty<*>, value: String) {
            Log.d("LOL", "$propertiesDelegates ${property.name} $value")
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
     * **Create delegate without new classes**
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

    private var classDelegate: String by ClassDelegate()
    private fun usingClassDelegate() {
        Log.d("LOL", classDelegate)
        classDelegate = "NEW VALUE"
        Log.d("LOL", classDelegate)
    }

    private fun usingObjectDelegate() {
        var varFunDelegate: String by objectDelegate()
        val valFunDelegate: String by objectDelegate()

        Log.d("LOL", varFunDelegate)
        varFunDelegate = "SOMETHING NEW"
        Log.d("LOL", varFunDelegate)

        // val cannot be reassigned error
        // valFunDelegate = "SOMETHING NEW"
    }
}