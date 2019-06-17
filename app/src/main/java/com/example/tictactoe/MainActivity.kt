package com.example.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun imageButtonTapped(view:View)
    {
        val selectedImageButton:ImageButton = view as ImageButton

        when(selectedImageButton.id)
        {
            R.id.imgButton1 -> tableLayout.setBackgroundColor(Color.BLACK)
        }
    }
}
