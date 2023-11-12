package com.example.learnstupidandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnstupidandroid.docs.computerScience.oop.OOP
import com.example.learnstupidandroid.docs.computerScience.pp.ProgrammingPrinciples
import com.example.learnstupidandroid.docs.computerScience.collections.Collections
import com.example.learnstupidandroid.docs.computerScience.delegate.Delegates
import com.example.learnstupidandroid.docs.language.AccessModifiers
import com.example.learnstupidandroid.docs.language.Classes
import com.example.learnstupidandroid.docs.language.Generics
import com.example.learnstupidandroid.docs.language.Functions
import com.example.learnstupidandroid.docs.language.inline.Inline
import com.example.learnstupidandroid.docs.language.Primitives
import com.example.learnstupidandroid.docs.language.inline.ValueClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Computer science
        Collections.init()
        ProgrammingPrinciples.init()
        OOP.init()
        Delegates.init()

        //Language
        Functions.init()
        Classes.init()
        AccessModifiers.init()
        Primitives.init()
        Inline.init()
        ValueClass.init()
        Generics.init()

        //Memory

        //Android
    }
}