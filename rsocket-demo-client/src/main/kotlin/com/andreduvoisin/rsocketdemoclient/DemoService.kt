package com.andreduvoisin.rsocketdemoclient

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DemoService(builder: RSocketRequester.Builder) {

    private val logger = LoggerFactory.getLogger(DemoService::class.java)

    private val requesterMono: Mono<RSocketRequester> = builder
            .dataMimeType(MediaType.APPLICATION_CBOR)
            .connectTcp("localhost", 8081)

    fun user(id: String): Mono<String> {
        logger.info("user(id), id={}", id)
        return requesterMono
                .flatMap {
                    it.route("user.{id}", id).retrieveMono(String::class.java)
                }
    }
}
