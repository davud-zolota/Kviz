package com.example.a1appkviz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.example.a1appkviz.model.Pitanje
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var pitanja: List<Pitanje> = listOf<Pitanje>(
        Pitanje("Da li je Sarajevo glvni grad bih", true),
        Pitanje("da li je nebo plavo", true),
        Pitanje("Da li je trava crvena", false)


    )
    var pocetniScore: Int = 0
    var indexTrenutnogPitanja = 0
    var zadnjePitanje = pitanja.size - 1
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateButtons()


        button_next.setOnClickListener {
            if (indexTrenutnogPitanja == zadnjePitanje || pitanja.isEmpty()) {
                Toast.makeText(this, "Nema vise pitanja", Toast.LENGTH_SHORT).show()

            } else {
                indexTrenutnogPitanja++
                updateButtons()
                text_pitanja.text = pitanja[indexTrenutnogPitanja].pitanje
            }


        }
        button_da.setOnClickListener {
            if (pitanja[indexTrenutnogPitanja].odgovori) {
                odgovoriTacno()
                Toast.makeText(this, "Vas odgovor je tacan", Toast.LENGTH_SHORT).show()

            } else {
                odgovoriNetacno()
                Toast.makeText(this, "Vas odgovor je netacan", Toast.LENGTH_SHORT).show()
            }

        }
        button_ne.setOnClickListener {
            if (pitanja[indexTrenutnogPitanja].odgovori) {
                odgovoriNetacno()
                Toast.makeText(this, "Vas odgovor je netacan", Toast.LENGTH_SHORT).show()
            } else {
                odgovoriTacno()
                Toast.makeText(this, "Vas odgovor je tacan", Toast.LENGTH_SHORT).show()
            }
        }
        button_nazad.setOnClickListener {
            if (indexTrenutnogPitanja == 0) {
                Toast.makeText(this, "Nema vise pitanja", Toast.LENGTH_SHORT).show()

            } else {
                indexTrenutnogPitanja--
                updateButtons()
                text_pitanja.text = pitanja[indexTrenutnogPitanja].pitanje
            }


        }
        button_restart.setOnClickListener {
            for (pitanje in pitanja) {
                pitanje.dalijeodgovoreno = false

            }
            updateText()
            updateButtons()
            upadateScore()

            Toast.makeText(this, "igraj ponovo", Toast.LENGTH_SHORT).show()

        }
    }

    private fun updateText() {
        text_pitanja.text = pitanja[0].pitanje
        score = 0
        pocetniScore = 0
        indexTrenutnogPitanja = 0
        zadnjePitanje = pitanja.size - 1


    }

    private fun updateButtons() {
        if (indexTrenutnogPitanja == 0) {
            button_nazad.isEnabled = false
            button_next.isEnabled = true
            button_restart.isEnabled = false
        } else if (indexTrenutnogPitanja == zadnjePitanje) {
            button_nazad.isEnabled = true
            button_next.isEnabled = false
            button_restart.isEnabled = false
        } else {
            button_nazad.isEnabled = true
            button_next.isEnabled = true
            button_restart.isEnabled = false
        }
        if (pitanja[indexTrenutnogPitanja].dalijeodgovoreno) {
            button_da.isEnabled = false
            button_ne.isEnabled = false
        } else {
            button_da.isEnabled = true
            button_ne.isEnabled = true


        }
        if (pitanja[zadnjePitanje].dalijeodgovoreno) {

            button_restart.isEnabled = true

        }

    }

    private fun upadateScore() {
        text_score.text = "Vas skor je $score"

    }

    private fun odgovoriTacno() {
        pitanja[indexTrenutnogPitanja].dalijeodgovoreno = true
        score += 10
        upadateScore()
        updateButtons()
    }

    private fun odgovoriNetacno() {
        pitanja[indexTrenutnogPitanja].dalijeodgovoreno = true
        score -= 10
        upadateScore()
        updateButtons()
    }


}























