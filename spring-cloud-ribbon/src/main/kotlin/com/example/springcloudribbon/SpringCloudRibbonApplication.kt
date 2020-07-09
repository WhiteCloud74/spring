package com.example.springcloudribbon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
class SpringCloudRibbonApplication{
    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().build()
    }
}

fun main(args: Array<String>) {
    runApplication<SpringCloudRibbonApplication>(*args)
}
