package com.example.my_application_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    var tvText: TextView? = null
    var cLayout: ConstraintLayout? = null

    var start: Boolean = false
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.tvText)
        cLayout = findViewById(R.id.cLayout)
        tvText?.setText(counter.toString())

        Thread {
            start = true
            while (start) {
                Thread.sleep(1000)
                runOnUiThread {
                    when(counter){
                        5 -> cLayout?.setBackgroundColor(Color.BLUE)
                        10 -> cLayout?.setBackgroundColor(Color.RED)
                        15 -> cLayout?.setBackgroundColor(Color.GREEN)
                    }
                    tvText?.setText(counter.toString())
                    counter++
                }
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
    }
}