package com.codenotfoundex.micro.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GreetingsRoute {
    @Bean
    public RouterFunction<ServerResponse> greetings() {

        return route(GET("/greetings"), request -> ServerResponse.ok().bodyValue("Hello, World! From Micro"));
    }
}
