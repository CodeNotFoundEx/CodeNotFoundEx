package com.codenotfoundex.micro.route;

import com.codenotfoundex.micro.cv.CvHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingsRoute {
    @Bean
    public RouterFunction<ServerResponse> greetings(ApiHandler apiHandler, CvHandler cvHandler) {


        return RouterFunctions.route()
                .path("/api", b -> b
                        .GET("/greetings", request -> ServerResponse.ok().bodyValue("Hello, World!"))
                        .GET("/secret", request -> ServerResponse.ok().bodyValue("Secret"))
                        .GET("/user", apiHandler::user)
                        .POST("/cv", cvHandler::parse)
                )
                .build();


    }
}
