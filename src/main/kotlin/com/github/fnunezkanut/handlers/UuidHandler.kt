package com.github.fnunezkanut.handlers

import com.github.fnunezkanut.models.UuidResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.time.Instant
import java.time.format.DateTimeFormatterBuilder
import java.util.*

@Component
class UuidHandler {

    fun main(req: ServerRequest): Mono<ServerResponse> {

        //current timestamp
        val dt = DateTimeFormatterBuilder().appendInstant(3).toFormatter().format(Instant.now()) ?: ""
        val uuid = UUID.randomUUID().toString()
        val uuidPromise = UuidResponse(
            dt = dt,
            uuid = uuid
        ).toMono()

        //respond with a 200 and json formatted uuid response object
        return ok().body(uuidPromise, UuidResponse::class.java)
    }
}