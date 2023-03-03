package com.vinayakgardi.quizapplication

object SetData {
    const val name : String = "name"
    const val score : String ="score"

   fun getQuestion() : ArrayList<QuestionData>{
     var que: ArrayList<QuestionData> = arrayListOf()
      var q1 = QuestionData(
         "Which planet has the most moons ? ",
         1,"Earth","Saturn ","Jupiter","Mercury",
         2
      )

      var q2 = QuestionData(
         "In what country was Elon Musk born ? ",
         2,"South Africa","India ","New Zealand","Canada",
         1
      )

      var q3 = QuestionData(
         "What software company is headquartered in Redmond, Washington ?",
         3,"Amazon","JP Morgan ","Microsoft","Netflix",
         3
      )

      var q4 = QuestionData(
         "What artist has the most streams on Spotify ?",
         4,"Zayn","Weeknd ","Justin Bieber","Drake",
         4
      )

      var q5 = QuestionData(
         "How many elements are in the periodic table ? ",
         5,"118","200 ","32","190",
         1
      )

      que.add(q1)
      que.add(q2)
      que.add(q3)
      que.add(q4)
      que.add(q5)
      return que
   }
}