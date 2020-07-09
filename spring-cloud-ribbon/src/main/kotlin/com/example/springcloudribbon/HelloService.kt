package com.example.springcloudribbon

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.client.RestTemplate

@Service
class HelloService {
    @Autowired
    lateinit var restTemplate: RestTemplate

    @HystrixCommand(fallbackMethod = "hiError")
    fun hiService(@RequestParam(value = "name", defaultValue = "world") name: String): String? {
        return restTemplate.getForObject("http://SPRING-CLOUD-EUREKA-CLIENT/hi?name=$name", String::class.java)
    }

    fun hiError(@RequestParam(value = "name", defaultValue = "world") name: String): String? {
        return "hi $name, sorry, error!"
    }
}