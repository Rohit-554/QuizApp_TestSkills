package com.example.quizapp_testskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultdeclaration.*

class resultdeclaration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultdeclaration)

        val username = intent.getStringExtra(QuestionsListing.name)
        val score    = intent.getStringExtra(QuestionsListing.score)
        val totalscore = intent.getStringExtra(QuestionsListing.totalscore)

        Congo.text="Congrutalations ${username}"
        disp_Score.text="${score}"+"/"+"${totalscore}"
        Quit.text="QUIT"
        Restart.text="RESTART"
        Quit.setOnClickListener{
            finish()
        }
        Restart.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }


}