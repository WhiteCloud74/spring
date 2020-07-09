package com.example.springcloudeurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class SpringCloudEurekaServerApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudEurekaServerApplication>(*args)
}
