package com.codenotfoundex.micro.route;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ApiHandler {
    public Mono<ServerResponse> user(ServerRequest serverRequest) {
        return serverRequest.principal()
                .cast(JwtAuthenticationToken.class)
                .flatMap(jwtToken -> {
                    return ServerResponse.ok().bodyValue(jwtToken);
                });
    }
}
