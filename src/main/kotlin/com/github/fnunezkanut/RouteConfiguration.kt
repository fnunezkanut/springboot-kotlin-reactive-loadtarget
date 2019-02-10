package com.github.fnunezkanut

import com.github.fnunezkanut.handlers.UuidHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouteConfiguration {

    @Bean
    fun router(uuidHandler: UuidHandler): RouterFunction<ServerResponse> {

        return route(GET("/uuid"), HandlerFunction(uuidHandler::main))
    }
}