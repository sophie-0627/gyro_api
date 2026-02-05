package dev.sophia.gyro.controller

data class quizData(
    val info: quizInfo,
    val score: quizScore,
    val data: List<question>
)

data class quizInfo(
    val name: String,
    val info: String,
    val version: String,
    val author: List<String>,
    val totalQuestionCount: Int
)

data class quizScore(
    val easy: Int,
    val medium: Int,
    val hard: Int,
    val penalty: Int
)

data class question(
    val id: Int,
    val content: String,
    val difficulty: String,
    val options: List<options>,
    val correctAnswer: List<Int>
)

data class options(
    val id: Int,
    val title: String
)

data class soundsAssets(
    val id: Int,
    val type: String,
    val url: String
)

data class AnswerRecord(
    val id: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val createAt: String
)