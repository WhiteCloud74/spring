package com.example.springcloudfeign

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HiController {
    @Autowired
    lateinit var schedualServiceHi: SchedualServiceHi

    @GetMapping(value = ["/hi"])
    fun sayHi(@RequestParam(value = "name", defaultValue = "world") name: String): String {
        println("feign $name")
        return schedualServiceHi.sayHiFromClientOne(name)
    }
}