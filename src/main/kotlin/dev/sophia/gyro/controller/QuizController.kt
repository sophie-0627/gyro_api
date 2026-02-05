package dev.sophia.gyro.controller

import dev.sophia.gyro.QuizService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class alldata(private val quizService: QuizService) {
    val list = mutableListOf(
        soundsAssets(0, "correct", "/sounds/correct.mp3"),
        soundsAssets(1, "wrong", "/sounds/wrong.mp3"),
        soundsAssets(2, "chose", "/sounds/chose.mp3")
    )
    private val records = mutableListOf<AnswerRecord>()

    @GetMapping("/data")
    fun getAllInfo(): quizData {
        return quizService.getData()
    }

    @GetMapping("/sounds")
    fun getAllSounds(): List<soundsAssets> = list


    @GetMapping("/records")
    fun getAllRecords(): List<AnswerRecord> = records

    @PostMapping("/records/post")
    fun addRecord(@RequestBody record: AnswerRecord) {
        records.add(record)
    }
}