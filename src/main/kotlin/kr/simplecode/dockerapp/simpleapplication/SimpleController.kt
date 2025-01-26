package kr.simplecode.dockerapp.simpleapplication

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, Docker Bind Mount!"
    }
}