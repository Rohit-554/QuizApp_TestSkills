package com.example.quizapp_testskills

object QuestionsListing{
    const val name:String="name"
    const val score:String = "score"
    const val totalscore : String = "Score"

fun getquestions(): ArrayList<QuestionPattern>{
 val questionList = ArrayList<QuestionPattern>()
    val q1 = QuestionPattern(1,"Where Is The HeadQuarters Located?",R.drawable.instagram,
        "California","London","Mumbai",
        "Beijing",1)

questionList.add(q1)
    val q2 = QuestionPattern(
        2, "Name This Character", R.drawable.djalaok_png,
        "Sova", "Dj Alok", "Harry", "BloodHound", 2
    )
    questionList.add(q2)
    //3
    val q3 = QuestionPattern(
        3, "What's The Amount To Develop This Game ?", R.drawable.rdr2,
        "$540mn", "$500mn", "$700mn", "$250mn", 1
    )
    questionList.add(q3)
    val q4 = QuestionPattern(
        4, "Which Country the Publisher Of The Game Belongs ?", R.drawable.valhala,
        "USA", "CANADA", "FRANCE", "JAPAN", 3
    )
    questionList.add(q4)
    val q5 = QuestionPattern(
        5, "Name The Publisher ?", R.drawable.pubg,
        "UbiSoft", "Tencent", "EpicGames", "Krafton", 4
    )
    questionList.add(q5)

return questionList
}

}