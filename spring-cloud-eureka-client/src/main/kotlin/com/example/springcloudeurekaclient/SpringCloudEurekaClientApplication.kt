package com.example.springcloudeurekaclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableEurekaClient
@RestController
class SpringCloudEurekaClientApplication {
    @Value("\${server.port}")
    lateinit var port: String

    @RequestMapping("/hi")
    fun home(@RequestParam(value = "name", defaultValue = "forest") name: String): String {
        return "hi $name ,i am from port:$port";
    }
}

fun main(args: Array<String>) {
    runApplication<SpringCloudEurekaClientApplication>(*args)
}
