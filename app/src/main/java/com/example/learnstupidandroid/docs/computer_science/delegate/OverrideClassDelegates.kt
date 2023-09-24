package com.example.learnstupidandroid.docs.computer_science.delegate

import android.util.Log

object OverrideClassDelegates {

        interface Base {
            fun printLn()
            fun logMessage()
        }

        class BaseImpl: Base {
            override fun printLn() {
                println("BaseImpl")
            }

            override fun logMessage() {
                Log.d("LOL", "BaseImpl")
            }
        }

        class BaseDelegated(baseImpl: BaseImpl) : Base by baseImpl {
            override fun logMessage() {
                Log.d("LOL1", "BaseDelegated")
            }
        }

        class BaseDelegated2() : Base by BaseImpl() {
            override fun logMessage() {
                Log.d("LOL2", "BaseDelegated2")
            }
        }

         fun init() {
             val base = BaseImpl()

             base.logMessage()
             base.printLn()

             BaseDelegated(base).printLn()
             BaseDelegated(base).logMessage()

             BaseDelegated2().logMessage()
             BaseDelegated2().printLn()
        }
    }