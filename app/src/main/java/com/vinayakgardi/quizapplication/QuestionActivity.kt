package com.vinayakgardi.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*
import kotlinx.android.synthetic.main.activity_question.view.*


class QuestionActivity : AppCompatActivity() {

    private var name :String? = null
    private var score : Int = 0

    private var currentPos : Int = 1
    private  var questionList : ArrayList<QuestionData>? = null
    private var selectedOption:Int = 0


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        name = intent.getStringExtra(SetData.name)


     questionList = SetData.getQuestion()
        setQuestion()

        opt_1.setOnClickListener{
            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener{
            selectedOptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener{
            selectedOptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener{
            selectedOptionStyle(opt_4,4)
        }

        submit.setOnClickListener {
            if(selectedOption!=0){
                val question = questionList!![currentPos-1]
                if(selectedOption!= question.correct_ans){
                   setColor(selectedOption ,R.drawable.wrong_question_option)
                }else{
                    score++
                }

                setColor(question.correct_ans , R.drawable.correct_question_option)
                if(currentPos == questionList!!.size)
                submit.text ="Finish"
                else
                    submit.text ="Next"
            }else{
                currentPos++
                when{
                    currentPos <=questionList!!.size->{
                        setQuestion()
                    }else->{
                    val intent = Intent(this,ResultActivity::class.java)
                    intent.putExtra(SetData.name,name.toString())
                    intent.putExtra(SetData.score,score.toString())

                    startActivity(intent)
                    finish()
                    }

                }

            }
            selectedOption =0
        }


    }

    fun setColor(opt : Int ,color : Int){
        when(opt){
            1->{
                opt_1.background =ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background =ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background =ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background =ContextCompat.getDrawable(this,color)
            }

        }

    }

    private fun setQuestion() {
       val question = questionList!![currentPos-1]
        setOptionStyle()
        progress_bar.progress = currentPos
        progress_bar.max = questionList!!.size
        progress_text.text ="$currentPos"+"/"+"${questionList!!.size}"
        question_text.text = question.question
        opt_1.text = question.option_1
        opt_2.text = question.option_2
        opt_3.text = question.option_3
        opt_4.text = question.option_4
    }

    fun setOptionStyle(){
        var optionList :ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }

    }

    fun selectedOptionStyle( view : TextView , opt: Int){

        setOptionStyle()
        selectedOption = opt
        view .background = ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}