package com.example.tictactoe

import android.content.DialogInterface
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity()
{
    enum class PlayingPlayer {
        Player1, Player2
    }

    enum class WinnerOfGame {
        Player1, Player2, NoOne
    }

//instance varibale
    var playingPlayer: PlayingPlayer? = null
    var winnerofGame: WinnerOfGame? = null
    var player1Options: ArrayList<Int> = ArrayList()
    var player2Options: ArrayList<Int> = ArrayList()
    var allDisabledImages: ArrayList<ImageButton?> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playingPlayer = PlayingPlayer.Player1
        // playingPlayer = PlayingPlayer.Player2
    }

    fun imageButtonTapped(view: View) {
        val selectedImageButton: ImageButton = view as ImageButton
        var randomNumber = (Math.random() * 9 + 1).toInt()
        var optionNumber = 0
        //Math.random() generates value b/w 0&1
        //randomNumber generated b/w 1-9 including 9
        when (randomNumber) {
            1 -> tableLayout.setBackgroundColor(Color.GREEN)
            2 -> tableLayout.setBackgroundColor(Color.RED)
            3 -> tableLayout.setBackgroundColor(Color.YELLOW)
            4 -> tableLayout.setBackgroundColor(Color.CYAN)
            5 -> tableLayout.setBackgroundColor(Color.WHITE)
            6 -> tableLayout.setBackgroundColor(Color.DKGRAY)
            7 -> tableLayout.setBackgroundColor(Color.LTGRAY)
            8 -> tableLayout.setBackgroundColor(Color.BLUE)
            9 -> tableLayout.setBackgroundColor(Color.MAGENTA)
        }

        when (selectedImageButton.id) {
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

        action(optionNumber, selectedImageButton)


    }

    private fun action(optionNumber: Int, _selectedImageButton: ImageButton) {

        var selectedImageButton = _selectedImageButton

        if (playingPlayer == PlayingPlayer.Player1) {
            selectedImageButton.setImageResource(R.drawable.x_icon)
            player1Options.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingPlayer = PlayingPlayer.Player2
        }

        else if (playingPlayer == PlayingPlayer.Player2) {
            //code for player 2
            selectedImageButton.setImageResource(R.drawable.o_icon)
           player2Options.add(optionNumber)
           selectedImageButton.isEnabled = false
           allDisabledImages.add(selectedImageButton)
          playingPlayer = PlayingPlayer.Player1

            //code for player 2 as computer
//            if (playingPlayer == PlayingPlayer.Player2) {
//             var notSelectedImage:ArrayList<Int> = ArrayList()    //holds not selected imagesnumbers of imageButton
//              for(imageNumber in 1..9)
//            {
//                     if(!(player1Options.contains(imageNumber)))
//                     {
//                         if(!(player2Options.contains(imageNumber))){
//
//                             notSelectedImage.add(imageNumber)
//                     }
//                }
//            }
//
//            try {
//                var randomNumber = (Math.random() * notSelectedImage.size).toInt()
//                var imageNumber = notSelectedImage[randomNumber]
//
//                when(imageNumber)
//                {
//                    1 -> selectedImageButton = imgButton1
//                    2 -> selectedImageButton = ImgButton2
//                    3 -> selectedImageButton = imgButton3
//                    4 -> selectedImageButton = imgButton4
//                    5 -> selectedImageButton = ImgButton5
//                    6 -> selectedImageButton = imgButton6
//                    7 -> selectedImageButton = imgButton7
//                    8 -> selectedImageButton = ImgButton8
//                    9 -> selectedImageButton = imgButton9
//                }
//
//                selectedImageButton.setImageResource(R.drawable.o_icon)
//                player2Options.add(imageNumber)
//                selectedImageButton.isEnabled = false
//                allDisabledImages.add(selectedImageButton)
//                playingPlayer = PlayingPlayer.Player1
//
//
//
//                }
//                catch (e:Exception)
//                {
//                    e.printStackTrace()
//            }





        }



        winnerOfGame()
    }

    private fun winnerOfGame() {
        if (player1Options.contains(1) && player1Options.contains(2) && player1Options.contains(3)) {
            winnerofGame = WinnerOfGame.Player1

        } else if (player2Options.contains(1) && player2Options.contains(2) && player2Options.contains(3)) {
            winnerofGame = WinnerOfGame.Player2
        } else if (player1Options.contains(4) && player1Options.contains(5) && player1Options.contains(6)) {
            winnerofGame = WinnerOfGame.Player1
        } else if (player2Options.contains(4) && player2Options.contains(5) && player2Options.contains(6)) {
            winnerofGame = WinnerOfGame.Player2
        } else if (player1Options.contains(3) && player1Options.contains(5) && player1Options.contains(7)) {
            winnerofGame = WinnerOfGame.Player1
        } else if (player2Options.contains(3) && player2Options.contains(5) && player2Options.contains(7)) {
            winnerofGame = WinnerOfGame.Player2
        } else if (player1Options.contains(7) && player1Options.contains(8) && player1Options.contains(9)) {
            winnerofGame = WinnerOfGame.Player1
        } else if (player2Options.contains(7) && player2Options.contains(8) && player2Options.contains(9)) {
            winnerofGame = WinnerOfGame.Player2
        } else if (player1Options.contains(1) && player1Options.contains(5) && player1Options.contains(9)) {
            winnerofGame = WinnerOfGame.Player1
        } else if (player2Options.contains(1) && player2Options.contains(5) && player2Options.contains(9)) {
            winnerofGame = WinnerOfGame.Player2
        } else if (player1Options.contains(1) && player1Options.contains(4) && player1Options.contains(7)) {
            winnerofGame = WinnerOfGame.Player1
        } else if (player2Options.contains(1) && player2Options.contains(4) && player2Options.contains(7)) {
            winnerofGame = WinnerOfGame.Player2
        } else if (player1Options.contains(2) && player1Options.contains(5) && player1Options.contains(8)) {
            winnerofGame = WinnerOfGame.Player1
        } else if (player2Options.contains(2) && player2Options.contains(5) && player2Options.contains(8)) {
            winnerofGame = WinnerOfGame.Player2
        } else if (player1Options.contains(3) && player1Options.contains(6) && player1Options.contains(9)) {
            winnerofGame = WinnerOfGame.Player1
        } else if (player2Options.contains(3) && player2Options.contains(6) && player2Options.contains(9)) {
            winnerofGame = WinnerOfGame.Player2
        }

        if (winnerofGame == WinnerOfGame.Player1) {
            createAlert("Player 1 Wins", "Congratulations to Player 1",
                AlertDialog.BUTTON_POSITIVE, "Ok", false)
            return     //return because we dont want to execute checkdraw function
        }
        else if (winnerofGame == WinnerOfGame.Player2)
        {
            createAlert("Player 2 Wins", "Congratulations to Player 2",
                AlertDialog.BUTTON_POSITIVE, "Ok", false)
                return
        }
        checkDraw()


}
    private fun  createAlert(title:String,message:String,whichButton:Int,buttonText:String,cancle:Boolean)
    {
             val alertDialog:AlertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setButton(whichButton,buttonText,{
            dialog: DialogInterface?, which: Int ->
            resetGame()
        })

        alertDialog.setCancelable(cancle)
        alertDialog.show()
    }

   private fun resetGame()
    {
        player1Options.clear()
        player2Options.clear()
        allDisabledImages.clear()
        winnerofGame = WinnerOfGame.NoOne
        playingPlayer = PlayingPlayer.Player1

        imgButton1.setImageResource(R.drawable.place_holder)
        imgButton3.setImageResource(R.drawable.place_holder)
        ImgButton2.setImageResource(R.drawable.place_holder)
        imgButton4.setImageResource(R.drawable.place_holder)
        ImgButton5.setImageResource(R.drawable.place_holder)
        imgButton6.setImageResource(R.drawable.place_holder)
        imgButton7.setImageResource(R.drawable.place_holder)
        ImgButton8.setImageResource(R.drawable.place_holder)
        imgButton9.setImageResource(R.drawable.place_holder)

        imgButton9.isEnabled = true
        imgButton7.isEnabled = true
        imgButton6.isEnabled = true
        imgButton4.isEnabled = true
        imgButton3.isEnabled = true
        ImgButton8.isEnabled = true
        ImgButton2.isEnabled = true
        ImgButton5.isEnabled = true
        imgButton1.isEnabled = true



    }


    private fun checkDraw()
    {
        if(allDisabledImages.size == 9 && winnerofGame!=WinnerOfGame.Player1 && winnerofGame!= WinnerOfGame.Player2)
        {
               createAlert("DRAW","No one won the game",AlertDialog.BUTTON_POSITIVE,"Ok",false)
        }
    }



}
