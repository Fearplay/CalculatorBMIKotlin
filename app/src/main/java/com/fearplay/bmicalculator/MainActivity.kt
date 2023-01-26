package com.fearplay.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var btnStart: Button? = null
    private var btnAbout: Button? = null
    private var btnQuit: Button? = null
    private var btnFirst: Button? = null
    private var btnSecond: Button? = null
    private var btnThird: Button? = null
    private var linearMain: LinearLayout? = null
    private var backgroundNumber: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById(R.id.btn_start)
        btnAbout = findViewById(R.id.btn_about)
        btnQuit = findViewById(R.id.btn_quit)
        btnFirst = findViewById(R.id.btn_first)
        btnSecond = findViewById(R.id.btn_second)
        btnThird = findViewById(R.id.btn_third)
        linearMain = findViewById(R.id.linear_main)
        supportActionBar?.title = "Menu"
        chooseBackground()
        onClick()

    }

    override fun onBackPressed() {
        finishAffinity()
    }

    private fun onClick() {
        btnStart?.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra(BACKGROUND_PICK, backgroundNumber)
            startActivity(intent)
        }
        btnAbout?.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            intent.putExtra(BACKGROUND_PICK, backgroundNumber)
            startActivity(intent)
        }
        btnQuit?.setOnClickListener {
            finishAffinity()
        }
        btnFirst?.setOnClickListener {
            linearMain?.setBackgroundResource(R.drawable.ic_bg1)

            backgroundNumber = 1
        }
        btnSecond?.setOnClickListener {
            linearMain?.setBackgroundResource(R.drawable.ic_bg2)
            backgroundNumber = 2
        }
        btnThird?.setOnClickListener {
            linearMain?.setBackgroundResource(R.drawable.ic_bg3)
            backgroundNumber = 3
        }

    }

    private fun chooseBackground() {
        backgroundNumber = intent.getIntExtra(BACKGROUND_PICK, 1)
        when (backgroundNumber) {
            1 -> {
                linearMain?.setBackgroundResource(R.drawable.ic_bg1)

            }
            2 -> {
                linearMain?.setBackgroundResource(R.drawable.ic_bg2)

            }
            3 -> {
                linearMain?.setBackgroundResource(R.drawable.ic_bg3)

            }
        }
    }

    companion object {
        const val BACKGROUND_PICK: String = "background_pick"
    }


}