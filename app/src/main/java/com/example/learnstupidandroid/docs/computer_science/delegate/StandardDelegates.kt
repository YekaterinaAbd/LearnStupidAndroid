package com.example.learnstupidandroid.docs.computer_science.delegate

import kotlin.properties.Delegates

object StandardDelegates {

    fun init() {
        lazyProperty()
        delegatesProperty()
        DelegateToAnotherProperty
        propertiesInMap()
    }

    /**
     * **by lazy()**
     *
     * [LazyThreadSafetyMode.SYNCHRONIZED] - default
     *
     * [LazyThreadSafetyMode.PUBLICATION] - only the first returned value will be used as the value of Lazy instance
     *
     * [LazyThreadSafetyMode.NONE] - no locks are used to synchronize an access, do not use if more than 1 thread
     */
    private fun lazyProperty() {
        val lazyString: String by lazy {
            println("initialized")
            "Something"
        }

        fun lazyWithInitializer(block: () -> String) {
            val lazyFun: String by lazy(block)
        }
    }

    /**
     * **[kotlin.properties.Delegates]**
     *
     * **by Delegates.observable()**
     * - initialValue - the initial value of the property
     * - onChange - the callback which is called after the change of the property is made.
     *
     * ```
     * var observableString by Delegates.observable("new") { property, oldValue, newValue ->
     *     //do something
     * }
     * ```
     *
     * **by Delegates.vetoable()**
     * - initialValue - the initial value of the property
     * - onChange - callback which is called before a change to the property value is attempted.
     * returns true or false, if false value is not changed
     *
     *```
     * var max: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
     *      // boolean function
     *      newValue > oldValue
     * }
     * ```
     *
     * **by Delegates.notNull()**
     *
     * getValue:
     * ```
     * return value ?: throw IllegalStateException("Property ${property.name} should be initialized before get.")
     * ```
     */
    private fun delegatesProperty() {

        // Delegated.observable()
        var observableString by Delegates.observable("initial") { property, oldValue, newValue ->
            println("$oldValue $newValue, ${property.name}")
        }
        observableString = "value1"
        observableString = "value2"

        // Delegates.vetoable()
        var vetoableString by Delegates.vetoable("a") { property, oldValue, newValue ->
            newValue.length > oldValue.length
        }
        vetoableString = "aaa" //value changed
        vetoableString = "a" // value not changed

        // Delegated.notNull()
        var notNullString by Delegates.notNull<String>()

    }

    /**
     * From Kotlin 1.4 **Delegating to another property**
     * - A top-level property
     * - A member or an extension property of the same class
     * - A member or an extension property of another class
     *
     */
    object DelegateToAnotherProperty {
        val topLevel: Int = 0

        class ClassWithDelegate(val param: String)
        class RenamedProperty(
            private val param: String,
            private val classWithDelegate: ClassWithDelegate
        ) {
            private var newName: String = ""

            //of the same class
            @Deprecated("Use newName instead")
            var name: String by this::newName

            //of the same class
            private val delegateParam: String by ::param

            // of another class
            private val delegateClassParam: String by classWithDelegate::param

            //of top-level property
            private val delegateTopLevel: Int by DelegateToAnotherProperty::topLevel
        }
    }

    /**
     * **Properties in a map**
     */
    class ClassForMapping(map: Map<String, Any?>) {
        val param1: String by map
        val param2: String by map
    }

    private fun propertiesInMap() {
        val classForMapping = ClassForMapping(
            mapOf("param1" to "1", "param2" to "2")
        )
        println(classForMapping.param1) //1
        println(classForMapping.param2) //2
    }
}