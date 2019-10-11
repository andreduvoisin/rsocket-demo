package com.andreduvoisin.rsocketdemoserver

import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
class DemoController {

    private val logger = LoggerFactory.getLogger(DemoController::class.java)

    @MessageMapping("user.{id}")
    fun user(@DestinationVariable id: String): Mono<String> {
        logger.info("user.{id}, id={}", id)
        return Mono.just("rsocket user: $id")
    }
}
