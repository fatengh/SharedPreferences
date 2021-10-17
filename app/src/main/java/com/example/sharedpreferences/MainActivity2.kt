package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private lateinit var tv1: TextView
    private lateinit var tv2: TextView

    private lateinit var btn1: Button
    private lateinit var btn2: Button

    lateinit var sf : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        sf = this.getSharedPreferences("SHF", Context.MODE_PRIVATE)


        btn1.setOnClickListener {
            val msg = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE)
            val tv = findViewById<TextView>(R.id.tv1).apply {
                text = msg
            }
        }
         btn2.setOnClickListener {
             val data = sf.getString("data", "Default Name")
             Toast.makeText(this, "Data Loaded ", Toast.LENGTH_SHORT).show()
             tv2.text = "$data"

         }


        }
    }
