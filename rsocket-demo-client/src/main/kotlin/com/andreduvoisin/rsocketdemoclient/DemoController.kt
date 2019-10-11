package com.andreduvoisin.rsocketdemoclient

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class DemoController(private val demoService: DemoService) {

    private val logger = LoggerFactory.getLogger(DemoController::class.java)

    @RequestMapping("/user/{id}")
    fun user(@PathVariable id: String): Mono<String> {
        logger.info("/user/{id}, id={}", id)
        return demoService.user(id)
    }
}
