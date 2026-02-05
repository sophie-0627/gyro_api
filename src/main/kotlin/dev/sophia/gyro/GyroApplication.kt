package dev.sophia.gyro

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class GyroApplication

fun main(args: Array<String>) {
	runApplication<GyroApplication>(*args)
}

@Configuration
class OpenAPIConfig {
	@Bean
	fun openAPI(): OpenAPI {
		return OpenAPI()
		.info(
			Info()
				.title("gyro遊戲 API")
				.version("v1.0.0")
		)
	}
}