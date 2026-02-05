package dev.sophia.gyro

import dev.sophia.gyro.controller.quizData
import jakarta.annotation.PostConstruct
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

@Service
class QuizService {
    private lateinit var quizData: quizData

    @PostConstruct
    fun init() {
        try {
            val input = ClassPathResource("Data Questions.json").inputStream
            val mapper = jacksonObjectMapper()
            quizData = mapper.readValue<quizData>(input)
        } catch (e: Exception) {
            println("讀取失敗: ${e.message}")
            e.printStackTrace()
        }
    }

    fun getData(): quizData = quizData
}