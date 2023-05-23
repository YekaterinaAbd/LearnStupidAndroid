package com.example.learnstupidandroid.docs.delegate

import android.util.Log
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object PropertiesDelegates {

    /**
     * val - provide getValue(thisRef: Owner, property: KProperty<*>)
     * var - provide getValue(...) and setValue(thisRef: Owner, property: KProperty<*>, value: Any?)
     *
     * functions must be operator fun
     */
    private var delegate: String by Delegate()
    private var funDelegate: String by objectDelegate()
    private val valFunDelegate: String by objectDelegate()

    fun init() {
        usingClassDelegate()
        usingObjectDelegate()
    }

    class Delegate {

        /**
        propertiesDelegates: Any - the object you read s from
        property: KProperty<*> - holds the description of s
        s: String - value being assigned
         */
        operator fun setValue(propertiesDelegates: Any, property: KProperty<*>, s: String) {
            Log.d("LOL", "$propertiesDelegates ${property.name} $s")
        }

        /**
         propertiesDelegates: Any - the object you read s from
         property: KProperty<*> - holds the description of s
         */
        operator fun getValue(propertiesDelegates: Any, property: KProperty<*>): String {
            return "$propertiesDelegates ${property.name}"
        }

    }

    /**
     * create delegate without new classes
     * use interface ReadOnlyProperty, ReadWriteProperty (can use ReadWriteProperty with val)
     */
    private fun objectDelegate(s: String = "SOMETHING"): ReadWriteProperty<Any?, String> =
        object: ReadWriteProperty<Any?, String> {
            var curValue = s
            override fun getValue(thisRef: Any?, property: KProperty<*>) = curValue
            override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
                curValue = value
            }
        }

    private fun usingClassDelegate() {
        Log.d("LOL", delegate)
        delegate = "NEW VALUE"
        Log.d("LOL", delegate)
    }

    private fun usingObjectDelegate() {
        Log.d("LOL", funDelegate)
        funDelegate = "SOMETHING NEW"
        Log.d("LOL", funDelegate)

        // val cannot be reassigned error
        // valFunDelegate = "SOMETHING NEW"
    }
 }