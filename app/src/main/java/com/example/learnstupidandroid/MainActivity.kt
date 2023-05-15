package com.example.learnstupidandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnstupidandroid.docs.OOP
import com.example.learnstupidandroid.docs.ProgrammingPrinciples
import com.example.learnstupidandroid.docs.collections.Collections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Collections.init()
        ProgrammingPrinciples.init()
        OOP.init()
    }
}