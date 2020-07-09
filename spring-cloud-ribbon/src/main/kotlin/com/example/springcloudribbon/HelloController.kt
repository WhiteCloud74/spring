package com.example.springcloudribbon

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @Autowired
    lateinit var helloService: HelloService

    @GetMapping(value = ["/hi"])
    fun hi(@RequestParam(value = "name", defaultValue = "world") name: String): String? {
        println("ribbon $name")
        return helloService.hiService(name)
    }
}