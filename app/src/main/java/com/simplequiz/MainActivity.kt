package com.simplequiz

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    val questions= listOf("Which company owns the android?", "Which one is not the programming language?", "Where you are watching this video?")
    val choice= listOf(
        listOf("Google", "Apple", "Nokia", "Sumsung"),
        listOf("Java", "Kotlin", "Notepad", "Python"),
        listOf("Faceboock", "Whatssap", "Instagram", "Youtube"))
    val correction= listOf("Google", "Notepad", "Youtube")

    lateinit var totalQuestion:TextView
    lateinit var question:TextView
    lateinit var a:Button
    lateinit var b:Button
    lateinit var c:Button
    lateinit var d:Button
    lateinit var submit:Button

    var score = 0
    var allQuestion = questions.size
    var currentQuestionIndex = 0
    var selectAnswer = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intialisation()
        totalQuestion.setText("total questions : $allQuestion")
//        onClick(submit)
        soso()
        finishQuiz()
        restatQuiz()

    }



    private fun intialisation(){
        totalQuestion =findViewById(R.id.totalQuestion)
        question=findViewById(R.id.question)
        a=findViewById(R.id.a)
        b=findViewById(R.id.b)
        c=findViewById(R.id.c)
        d=findViewById(R.id.d)
        submit=findViewById(R.id.submit)

    }
    private fun loadNewQuestion(){
        if (currentQuestionIndex == allQuestion.toInt()) {
                finishQuiz()
                return
            }
            question.setText(questions[currentQuestionIndex])
            a.setText(choice[currentQuestionIndex][0])
            b.setText(choice[currentQuestionIndex][1])
            c.setText(choice[currentQuestionIndex][2])
            d.setText(choice[currentQuestionIndex][3])
        a.setBackgroundColor(Color.YELLOW)
        b.setBackgroundColor(Color.YELLOW)
        c.setBackgroundColor(Color.YELLOW)
        d.setBackgroundColor(Color.YELLOW)
    }
//    private fun onClick(view : View){
//        a.setBackgroundColor(Color.YELLOW)
//        b.setBackgroundColor(Color.YELLOW)
//        c.setBackgroundColor(Color.YELLOW)
//        d.setBackgroundColor(Color.YELLOW)
//
//        var clickedButoon:Button = view as Button
//        if (clickedButoon.id==R.id.submit){
//            currentQuestionIndex++
//            loadNewQuestion()
//            if (selectAnswer.equals(correction[currentQuestionIndex])){
//                score++
//            }
//        }else{
//            //choices button clicked
//            selectAnswer = clickedButoon.text.toString()
//            clickedButoon.setBackgroundColor(Color.MAGENTA)
//        }
//    }
    fun soso(){
//       val clickedButoon:Button =findViewById(view.id)
        a.setBackgroundColor(Color.YELLOW)
        b.setBackgroundColor(Color.YELLOW)
        c.setBackgroundColor(Color.YELLOW)
        d.setBackgroundColor(Color.YELLOW)
        if (submit.isClickable){
            submit.setOnClickListener {
                if (selectAnswer.equals(correction[currentQuestionIndex])){
                    score++
                }
                currentQuestionIndex++
                loadNewQuestion()
               }
        }
        a.setOnClickListener{
            selectAnswer = a.text.toString()
            a.setBackgroundColor(Color.MAGENTA)
        }
        b.setOnClickListener{
            selectAnswer = b.text.toString()
            b.setBackgroundColor(Color.MAGENTA)
        }
        c.setOnClickListener{
            selectAnswer = c.text.toString()
            c.setBackgroundColor(Color.MAGENTA)
        }
        d.setOnClickListener{
            selectAnswer = d.text.toString()
            d.setBackgroundColor(Color.MAGENTA)
        }
//        else{
//            //choices button clicked
//            selectAnswer = clickedButoon.text.toString()
//            clickedButoon.setBackgroundColor(Color.MAGENTA)

        }
    private fun finishQuiz() {
        var passStatus:String=""
        if (score > (allQuestion)*0.68){
            passStatus="PASSED"
        }else{
            passStatus="FAILED"
        }

        val snac =Snackbar.make(a, "$passStatus ->\n\tScore is : $score out of $allQuestion\"", Snackbar.LENGTH_LONG)
        snac.show()
        snac.setAction("Restart"){
            restatQuiz()
        }
    }
    private fun restatQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion()
    }

    }

//}