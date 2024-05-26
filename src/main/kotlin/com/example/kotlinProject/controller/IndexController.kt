package com.example.kotlinProject.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/str")
    fun home(): String {
        return "String"
    }
}
