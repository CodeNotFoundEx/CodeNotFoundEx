package com.codenotfoundex.micro.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingsRoute {
    @Bean
    public RouterFunction<ServerResponse> greetings() {


        return RouterFunctions.route()
                .path("/api", b -> b
                        .GET("/greetings", request -> ServerResponse.ok().bodyValue("Hello, World!"))
                        .GET("/secret", request -> ServerResponse.ok().bodyValue("Secret")))
                .build();


    }
}
