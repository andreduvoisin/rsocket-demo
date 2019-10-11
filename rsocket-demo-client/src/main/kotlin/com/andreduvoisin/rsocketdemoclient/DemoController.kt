package com.andreduvoisin.rsocketdemoclient

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class DemoController(private val builder: RSocketRequester.Builder) {

    private val logger = LoggerFactory.getLogger(DemoController::class.java)

    private val requesterMono: Mono<RSocketRequester> = builder
            .dataMimeType(MediaType.APPLICATION_CBOR)
            .connectTcp("localhost", 8081)

    @RequestMapping("/user/{id}")
    fun user(@PathVariable id: String): Mono<String> {
        logger.debug("/user/{id}, id={}", id)
        return requesterMono
                .flatMap {
                    it.route("user.{id}", id).retrieveMono(String::class.java)
                }
    }
}
