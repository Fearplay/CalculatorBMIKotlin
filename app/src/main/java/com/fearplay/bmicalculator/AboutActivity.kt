package com.fearplay.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    private var backgroundNumber: Int = 1
    private var linearAbout: LinearLayout? = null
    private var mBackPressed: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        linearAbout = findViewById(R.id.linear_about)
        supportActionBar?.title = "About"
        chooseBackground()

    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.BACKGROUND_PICK, backgroundNumber)
        startActivity(intent)
        return true
    }


    private fun chooseBackground() {
        backgroundNumber = intent.getIntExtra(MainActivity.BACKGROUND_PICK, 1)
        when (backgroundNumber) {
            1 -> {
                linearAbout?.setBackgroundResource(R.drawable.ic_bg1)

            }
            2 -> {
                linearAbout?.setBackgroundResource(R.drawable.ic_bg2)

            }
            3 -> {
                linearAbout?.setBackgroundResource(R.drawable.ic_bg3)

            }
        }
    }


}