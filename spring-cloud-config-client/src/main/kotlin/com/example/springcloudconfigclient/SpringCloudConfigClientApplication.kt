package com.example.springcloudconfigclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class SpringCloudConfigClientApplication {
    @Value("\${foo}")
    lateinit var foo: String

    @RequestMapping("/hi")
    fun hi(): String {
        return foo
    }
}

fun main(args: Array<String>) {
    runApplication<SpringCloudConfigClientApplication>(*args)
}
