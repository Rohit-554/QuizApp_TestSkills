package com.example.quizapp_testskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Start.setOnClickListener{
                 if(et_text.text.toString().isEmpty())
                 {
                     Toast.makeText(this, "You Haven't Entered Your Name Yet :( ", Toast.LENGTH_SHORT).show()
                 }
            else
                 {
                     val intent = Intent(this,QuizPanel::class.java)
                     intent.putExtra("${QuestionsListing.name}",et_text.text.toString())
                     startActivity(intent)
                     finish()
                 }
        }


    }
}