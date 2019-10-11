package com.andreduvoisin.rsocketdemoclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsocketDemoClientApplication

fun main(args: Array<String>) {
	runApplication<RsocketDemoClientApplication>(*args)
}
