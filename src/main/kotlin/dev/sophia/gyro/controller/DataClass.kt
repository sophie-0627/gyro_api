package dev.sophia.gyro.controller

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JacksonXmlRootElement(localName = "Sound") // 單個物件的標籤名稱
data class soundsAssets(
    @JacksonXmlProperty(localName = "id")
    val id: Int,
    @JacksonXmlProperty(localName = "name")
    val name: String,
    @JacksonXmlProperty(localName = "url")
    val url: String
)