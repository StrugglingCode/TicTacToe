package com.example.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    enum class PlayingPlayer
    {
        Player1,Player2
    }

    enum class WinnerOfGame
    {
        Player1,Player2,No_One
    }
//instance varibale

    var playingPlayer:PlayingPlayer? = null
    var winnerofGame:WinnerOfGame? = null

    var player1Options:ArrayList<Int> = ArrayList()
    var allDisabledImages:ArrayList<ImageButton?> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playingPlayer = PlayingPlayer.Player1
       // playingPlayer = PlayingPlayer.Player2
    }

    fun imageButtonTapped(view:View)
    {
        val selectedImageButton:ImageButton = view as ImageButton
        var randomNumber = (Math.random()* 9 + 1).toInt()
        var optionNumber = 0
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

        when(selectedImageButton.id)
        {
            R.id.imgButton1 -> optionNumber = 1
            R.id.ImgButton2 -> optionNumber = 2
            R.id.imgButton3 -> optionNumber = 3
            R.id.imgButton4 -> optionNumber = 4
            R.id.ImgButton5 -> optionNumber = 5
            R.id.imgButton6 -> optionNumber = 6
            R.id.imgButton7 -> optionNumber = 7
            R.id.ImgButton8 -> optionNumber = 8
            R.id.imgButton9 -> optionNumber = 9
        }

        action(optionNumber,selectedImageButton)


    }

    private fun action(optionNumber:Int,selectedImageButton:ImageButton)
    {
        if(playingPlayer == PlayingPlayer.Player1)
        {
            selectedImageButton.setImageResource(R.drawable.x_icon)
            player1Options.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingPlayer = PlayingPlayer.Player2
        }
    }






}
