package com.modinfsystems.rescolorbug

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val viewToChange = findViewById<View>(R.id.viewToChange)

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val alpha = if(p1 > 255) {
                    255
                } else {
                    p1
                }

                // Set alpha to background of view. We want just to change alpha of the only view.
                // But it changes alpha of all views that uses that color (we don't even need the
                // same color resource, just same HEX)
                viewToChange.background.alpha = alpha
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // nothing
            }
        })

        // Set default value
        seekBar.progress = 128

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}