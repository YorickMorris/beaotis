package com.ebookfrenzy.beaotis.pairing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_pairing.*

class Pairing : AppCompatActivity() {
    private lateinit var intentToMainActivity:Intent

    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<MemoryCard>
    private var indexOfSingleSelectedCard: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pairing)
        intentToMainActivity=Intent(this, MainActivity::class.java)

        val images = mutableListOf(R.drawable.ananas, R.drawable.elma, R.drawable.cilek)
        images.addAll(images)
        images.shuffle()

        buttons = listOf(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
            imageButton6)

        cards = buttons.indices.map { index ->
            MemoryCard(images[index])
        }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                // Modelleri güncelle
                updateModels(index)
                // Oyunun arayüzünü güncelle
                updateViews()
            }
        }

        left_arrow10.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun updateViews() {
        cards.forEachIndexed { index, card ->
            val button = buttons[index]
            if (card.isMatched) {
                button.alpha = 0.1f
            }
            button.setImageResource(if (card.isFaceUp) card.identifier else R.drawable.cardgame)
        }
    }

    private fun updateModels(position: Int) {
        val card = cards[position]
        // Hata Kontrolü:
        if (card.isFaceUp) {
            Toast.makeText(this, "Yanlış Hamle!", Toast.LENGTH_SHORT).show()
            return
        }
        // 3 Farklı durum
        // 0 kartlar yeni döndü=> kartları yenile ve yeni seçilen kartı aç
        // 1 kart yeni döndü => seçilen kartı döndür ve eşleşme var mı diye bak
        // 2 cards previously flipped over => kartları yenile, seçilen kartı döndür
        if (indexOfSingleSelectedCard == null) {
            // 0 veya 2 kart seçildiyse
            restoreCards()
            indexOfSingleSelectedCard = position
        } else {
            // önceden bir kart seçildi
            checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
    }

    private fun restoreCards() {
        for (card in cards) {
            if (!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

    private fun checkForMatch(position1: Int, position2: Int) {
        if (cards[position1].identifier == cards[position2].identifier) {
            Toast.makeText(this, "Eşleşti!!", Toast.LENGTH_SHORT).show()
            cards[position1].isMatched = true
            cards[position2].isMatched = true
        }
    }



    override fun onBackPressed() {
        startActivity(intentToMainActivity)
        super.onBackPressed()
    }

    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }

    override fun onStart() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onStart()
    }
}