package com.example.learnstupidandroid.docs.computerScience.delegate

import android.util.Log

object OverrideClassDelegates {

    /** Base delegate interface**/
    interface Base {
        fun printLn()
        fun logMessage()
    }

    /**Implementation of base**/
    class BaseImpl : Base {
        override fun printLn() {
            println("BaseImpl")
        }

        override fun logMessage() {
            Log.d("LOL", "BaseImpl")
        }
    }

    /**BaseImpl in params with override**/
    class BaseDelegated(baseImpl: BaseImpl) : Base by baseImpl {
        override fun logMessage() {
            Log.d("LOL1", "BaseDelegated")
        }
    }

    /**BaseImpl with override method**/
    class BaseDelegated2 : Base by BaseImpl() {
        override fun logMessage() {
            Log.d("LOL2", "BaseDelegated2")
        }
    }

    fun init() {
        val base = BaseImpl()

        // output: BaseImpl
        base.logMessage()
        base.printLn()

        // output:
        // println - BaseImpl
        // logMessage - BaseDelegated
        BaseDelegated(base).printLn()
        BaseDelegated(base).logMessage()

        // output:
        // println - BaseImpl
        // logMessage - BaseDelegated2
        BaseDelegated2().logMessage()
        BaseDelegated2().printLn()
    }
}