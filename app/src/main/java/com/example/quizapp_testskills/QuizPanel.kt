package com.example.quizapp_testskills

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_panel2.*
import java.io.StreamCorruptedException
import kotlin.math.max

class QuizPanel : AppCompatActivity(){


    private var Name:String?= "name"
    private var Score:Int =0
    private var mCurrentPosition: Int = 1
    private var mSelectedOption: Int = 0
    private var mQuestionList: ArrayList<QuestionPattern>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_panel2)

        Name=intent.getStringExtra(QuestionsListing.name)
        mQuestionList=QuestionsListing.getquestions()
        setquestion()

        optionone.setOnClickListener(){
        slctdoptnstyle(optionone,1)
        }
        optiontwo.setOnClickListener(){
            slctdoptnstyle(optiontwo,2)
        }
        optionthree.setOnClickListener(){
            slctdoptnstyle(optionthree,3)
        }
        optionfour.setOnClickListener(){
            slctdoptnstyle(optionfour,4)
        }
        submit_button.setOnClickListener(){
            if(mSelectedOption!=0)
            {
                var checkans = mQuestionList!![mCurrentPosition-1]
                if(mSelectedOption!=checkans.Correct_answer)
                {
                    setans(mSelectedOption,R.drawable.wrong_border)
                }else{
                    Score=Score+1
                }
                setans(checkans.Correct_answer,R.drawable.correct_border)
                if(mCurrentPosition==mQuestionList!!.size) {
                    submit_button.text="FINISH"
                }
                else{
                    setOptionsEnabled() // Disable question options
                    submit_button.text="Go To Next Question "
                }
            }else {
                mCurrentPosition++
                when {
                    mCurrentPosition <= mQuestionList!!.size -> {
                        setquestion()
                        setOptionsEnabled() // Enable question options
                    }

                    else -> {
                        var intent = Intent(this,resultdeclaration::class.java)
                        intent.putExtra(QuestionsListing.name,Name.toString())
                        intent.putExtra(QuestionsListing.score,Score.toString())
                        intent.putExtra(QuestionsListing.totalscore,mQuestionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }

            }
            mSelectedOption=0
        }

    }
    fun setans(opt:Int , color:Int){
        when(opt){
            1->{optionone.background=ContextCompat.getDrawable(this,color)}
            2->{optiontwo.background=ContextCompat.getDrawable(this,color)}
            3->{optionthree.background=ContextCompat.getDrawable(this,color)}
            4->{optionfour.background = ContextCompat.getDrawable(this,color)}

        }
    }
    fun setquestion() {
        val question = mQuestionList!![mCurrentPosition-1]
        defaultborder()

        progress_bar.progress=mCurrentPosition
        progress_bar.max = mQuestionList!!.size
        Progress_text.text ="${mCurrentPosition}"+"/"+progress_bar.max
        question_text.text=question.Question_text
        tv_image.setImageResource(question.Image)
        optionone.text = question.Option_one
        optiontwo.text = question.Option_Two
        optionthree.text = question.Option_Three
        optionfour.text = question.Option_Four
    }
    fun defaultborder(){
        var optionlist = ArrayList<TextView>()
            optionlist.add(0,optionone)
            optionlist.add(1,optiontwo)
            optionlist.add(2,optionthree)
            optionlist.add(3,optionfour)

        for(op in optionlist)
        {
            op.setTextColor(Color.parseColor("#ACA4A4"))
            op.typeface= Typeface.DEFAULT
            op.background=ContextCompat.getDrawable(this,R.drawable.display_border)
        }
    }
    fun slctdoptnstyle(view: TextView,opt:Int)
    {
        defaultborder()
        mSelectedOption=opt
        view.background = ContextCompat.getDrawable(this,R.drawable.selected_border)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }

    /**
     * Enable or disable options based on
     * whether the submit button has been clicked.
     */
    private fun setOptionsEnabled() {
        optionone.isEnabled = !optionone.isEnabled
        optiontwo.isEnabled = !optiontwo.isEnabled
        optionthree.isEnabled = !optionthree.isEnabled
        optionfour.isEnabled = !optionfour.isEnabled
    }
}


