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
        var randomNumber = (Math.random()* 9 + 1).toInt()
        //Math.random() generates value b/w 0&1
        //randomNumber generated b/w 1-9 including 9
        when(randomNumber)
        {
            1-> tableLayout.setBackgroundColor(Color.GREEN)
            2-> tableLayout.setBackgroundColor(Color.RED)
            3-> tableLayout.setBackgroundColor(Color.YELLOW)
            4-> tableLayout.setBackgroundColor(Color.CYAN)
            5-> tableLayout.setBackgroundColor(Color.WHITE)
            6-> tableLayout.setBackgroundColor(Color.DKGRAY)
            7-> tableLayout.setBackgroundColor(Color.LTGRAY)
            8-> tableLayout.setBackgroundColor(Color.BLUE)
            9-> tableLayout.setBackgroundColor(Color.MAGENTA)



        }

    }
}
