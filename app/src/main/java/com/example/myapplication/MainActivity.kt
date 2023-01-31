package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var image_1:ImageView
    private lateinit var image_2:ImageView
    private lateinit var image_3:ImageView
    private lateinit var image_4:ImageView
    private lateinit var image_5:ImageView
    private lateinit var image_6:ImageView
    private lateinit var image_7:ImageView
    private lateinit var image_8:ImageView
    private lateinit var image_9:ImageView
    private lateinit var active_player:TextView
    private lateinit var winner:TextView


    var matrix = Array(3) { IntArray(3) { -1 } }
    var active = true
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_1=findViewById(R.id.image_1)
        image_2=findViewById(R.id.image_2)
        image_3=findViewById(R.id.image_3)
        image_4=findViewById(R.id.image_4)
        image_5=findViewById(R.id.image_5)
        image_6=findViewById(R.id.image_6)
        image_7=findViewById(R.id.image_7)
        image_8=findViewById(R.id.image_8)
        image_9=findViewById(R.id.image_9)
        active_player=findViewById(R.id.user_1_name)
        winner=findViewById(R.id.winner)



        image_1.setOnClickListener(this)
        image_2.setOnClickListener(this)
        image_3.setOnClickListener(this)
        image_4.setOnClickListener(this)
        image_5.setOnClickListener(this)
        image_6.setOnClickListener(this)
        image_7.setOnClickListener(this)
        image_8.setOnClickListener(this)
        image_9.setOnClickListener(this)
        /*restart.setOnClickListener {
            restart()
        }*/

    }

    override fun onClick(p0: View?) {
        val img = findViewById<ImageView>(p0!!.id)
        var t = img.tag.toString().toInt()
        var col: Int = t / 3
        var row: Int = t % 3
        if (matrix[col][row] == -1) {
            if (active) {
                img.setImageResource(R.drawable.x)
                active = false
                matrix[col][row] = 1
                active_player.text = "Player 0"
                isWinner(1)
            } else {
                img.setImageResource(R.drawable.o)
                active = true
                matrix[col][row] = 0
                active_player.text = "Player X"
                isWinner(0)
            }
        }


    }

    fun isWinner(a: Int) {
        var count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + a
                finishGame()
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + a
                finishGame()
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            winner.text = "Winner is " + a
            finishGame()
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            winner.text = "Winner is " + a
            finishGame()
            return
        }
    }

    fun finishGame() {
        image_1.isEnabled = false
        image_2.isEnabled = false
        image_3.isEnabled = false
        image_4.isEnabled = false
        image_5.isEnabled = false
        image_6.isEnabled = false
        image_7.isEnabled = false
        image_8.isEnabled = false
        image_9.isEnabled = false
        //restart.visibility = View.VISIBLE
    }

    fun restart() {
        matrix = Array(3) { IntArray(3) { -1 } }
        active = true
        active_player.text = "Player X"

        //restart.visibility = View.INVISIBLE

        winner.text = ""

        image_1.isEnabled = true
        image_2.isEnabled = true
        image_3.isEnabled = true
        image_4.isEnabled = true
        image_5.isEnabled = true
        image_6.isEnabled = true
        image_7.isEnabled = true
        image_8.isEnabled = true
        image_9.isEnabled = true

        image_1.setImageDrawable(null)
        image_2.setImageDrawable(null)
        image_3.setImageDrawable(null)
        image_4.setImageDrawable(null)
        image_5.setImageDrawable(null)
        image_6.setImageDrawable(null)
        image_7.setImageDrawable(null)
        image_8.setImageDrawable(null)
        image_9.setImageDrawable(null)

    }
}