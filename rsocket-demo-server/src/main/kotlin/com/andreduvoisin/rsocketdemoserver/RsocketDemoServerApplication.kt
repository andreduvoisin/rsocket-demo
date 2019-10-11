package com.andreduvoisin.rsocketdemoserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsocketDemoServerApplication

fun main(args: Array<String>) {
	runApplication<RsocketDemoServerApplication>(*args)
}
