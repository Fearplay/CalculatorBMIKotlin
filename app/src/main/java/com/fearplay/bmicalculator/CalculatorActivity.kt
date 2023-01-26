package com.fearplay.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {
    private var linearCalculator: LinearLayout? = null
    private var tvResult: TextView? = null
    private var etHeight: EditText? = null
    private var etWeight: EditText? = null
    private var btnCalc: Button? = null
    private var backgroundNumber: Int = 1
    private var heightCm: Double = 0.0
    private var heightM: Double = 0.0
    private var weightKg: Double = 0.0
    private var result: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        linearCalculator = findViewById(R.id.linear_calculator)
        tvResult = findViewById(R.id.tv_result)
        etHeight = findViewById(R.id.et_height)
        etWeight = findViewById(R.id.et_weight)
        btnCalc = findViewById(R.id.btn_calculator)
        supportActionBar?.title = "Calculator"
        chooseBackground()
        btnCalc?.setOnClickListener {
            countResult()
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.BACKGROUND_PICK, backgroundNumber)
        startActivity(intent)
        finish()
        return true
    }

    @SuppressLint("SetTextI18n")
    private fun countResult() {
        try {
            heightCm = etHeight?.text.toString().toDouble()
            heightM = heightCm / 100
            weightKg = etWeight?.text.toString().toDouble()
            result = weightKg / (heightM * heightM)


            val df = DecimalFormat("0.00")
            val resultFormat = df.format(result).toString()
            if (result.isInfinite()) {
                Toast.makeText(this, R.string.toast_zero, Toast.LENGTH_SHORT).show()
                tvResult?.text = ""
            } else if (result < 18.5) {
                tvResult?.setBackgroundResource(R.color.underweight)
                tvResult?.text = getString(R.string.result_text) + " $resultFormat"
            } else if (result >= 18.5 && result < 25) {
                tvResult?.setBackgroundResource(R.color.normal)
                tvResult?.text = getString(R.string.result_text) + " $resultFormat"
            } else if (result >= 25 && result < 30) {
                tvResult?.setBackgroundResource(R.color.overweight)
                tvResult?.text = getString(R.string.result_text) + " $resultFormat"
            } else if (result > 29.9) {
                tvResult?.setBackgroundResource(R.color.obese)
                tvResult?.text = getString(R.string.result_text) + " $resultFormat"
            } else {

                Toast.makeText(this, R.string.toast_zero, Toast.LENGTH_SHORT).show()
                tvResult?.text = ""
            }
        } catch (e: Exception) {
            Toast.makeText(this, R.string.toast_both_fields, Toast.LENGTH_SHORT).show()
        }
    }

    private fun chooseBackground() {
        backgroundNumber = intent.getIntExtra(MainActivity.BACKGROUND_PICK, 1)
        when (backgroundNumber) {
            1 -> {
                linearCalculator?.setBackgroundResource(R.drawable.ic_bg1)
            }
            2 -> {
                linearCalculator?.setBackgroundResource(R.drawable.ic_bg2)

            }
            3 -> {

                linearCalculator?.setBackgroundResource(R.drawable.ic_bg3)
            }
        }
    }
}