package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var ed1:EditText
    private lateinit var ed2:EditText

    private lateinit var btn1:Button
    private lateinit var btn2:Button

    lateinit var sf : SharedPreferences
    lateinit var editr :SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        sf = this.getSharedPreferences("SHF", Context.MODE_PRIVATE)

        btn1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(AlarmClock.EXTRA_MESSAGE,"${ed1.text}" )
            startActivity(intent)
        }

        btn2.setOnClickListener {
            with(sf.edit()) {
                putString("data", ed2.text.toString())
                apply()
            }
            Toast.makeText(this, "Data Saved ", Toast.LENGTH_SHORT).show()
        }


    }
}