package com.example.springcloudfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "spring-cloud-eureka-client", fallback = SchedualServiceHiHystric::class)
interface SchedualServiceHi {
    @RequestMapping(value = ["/hi"], method = arrayOf(RequestMethod.GET))
    fun sayHiFromClientOne(@RequestParam(value = "name", defaultValue = "world") name: String): String
}