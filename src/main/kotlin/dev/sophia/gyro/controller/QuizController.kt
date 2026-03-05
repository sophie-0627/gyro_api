package dev.sophia.gyro.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/api")
class AllDataController {
    val soundList = mutableListOf(
        soundsAssets(0, "correct", "/sounds/correct.mp3"),
        soundsAssets(1, "wrong", "/sounds/wrong.mp3"),
        soundsAssets(2, "chose", "/sounds/chose.mp3")
    )
    private val records = mutableListOf<AnswerRecord>()

    @Tag(name = "data")
    @GetMapping("/xml/data", produces = ["application/xml"])
    fun getXMLData(): String {
        val xmlString = object {}.javaClass.getResource("/Questions.xml")?.readText()
        return xmlString ?: "<error>找不到資料</error>"
    }

    @Tag(name = "add data")
    @PostMapping(
        "/records/post",
        consumes = ["application/xml"],
        produces = ["application/xml"]
    )
    fun addRecord(@RequestBody record: AnswerRecord): AnswerRecord {
        records.add(record)
        return record
    }

    @Tag(name = "data")
    @GetMapping("/records", produces = ["application/xml"])
    fun getAllRecords(): List<AnswerRecord> = records

    @Tag(name = "delete")
    @DeleteMapping("/records/{id}")
    fun deleteRecord(@PathVariable("id") id: Int): String {
        val remove = records.removeIf { it.id == id }
        return if(remove){
            "成功刪除"
        } else {
            "沒有該 ID 資料"
        }
    }

    @Tag(name = "delete")
    @DeleteMapping("/records/all")
    fun deleteAllRecords(): String {
        records.clear()
        return "已清空"
    }

    @Tag(name = "sounds")
    @GetMapping("/sounds", produces = ["application/xml"])
    fun getAllSounds(): List<soundsAssets> = soundList

    @Tag(name = "sounds")
    @PostMapping("/sounds/post", consumes = ["application/xml"], produces = ["application/xml"])
    fun addSound(@RequestBody newSound: soundsAssets): soundsAssets {
        soundList.add(newSound)
        return newSound
    }
}

@JacksonXmlRootElement(localName = "AnswerRecord")
data class AnswerRecord(
    @JacksonXmlProperty(localName = "id")
    val id: Int,
    @JacksonXmlProperty(localName = "answer")
    val answer: String
)
