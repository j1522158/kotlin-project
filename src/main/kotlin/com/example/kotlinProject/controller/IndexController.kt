package com.example.kotlinProject.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/str")
    fun home(): String {
        return "index"
    }
}

@Controller
class TestController{

    @GetMapping("/")
    fun home(): String {
        return "index"
    }
}