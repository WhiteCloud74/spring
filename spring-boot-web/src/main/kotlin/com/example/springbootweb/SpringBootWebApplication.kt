package com.example.springbootweb

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class SpringBootWebApplication

fun main(args: Array<String>) {
    runApplication<SpringBootWebApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
