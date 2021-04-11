package com.example.kviz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDa = findViewById<Button>(R.id.button_da)
        val buttonNe = findViewById<Button>(R.id.button_ne)
        val textPitanja = findViewById<TextView>(R.id.text_pitanja)

        buttonDa.setOnClickListener {
            Toast.makeText(this, "Vas odgovor je tacan", Toast.LENGTH_SHORT).show()
        }

        buttonNe.setOnClickListener {
            Toast.makeText(this, "Vas odgovor je netacan", Toast.LENGTH_SHORT).show()
        }

    }
}



