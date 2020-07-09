package com.example.springcloudfeign

import org.springframework.stereotype.Component

@Component
final class SchedualServiceHiHystric : SchedualServiceHi {
    override fun sayHiFromClientOne(name: String): String {
        return "sorry $name"
    }
}