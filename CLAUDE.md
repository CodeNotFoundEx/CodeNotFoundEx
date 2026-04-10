# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Repository Layout

This is a monorepo at `/Users/moldo/code/codeNotFoundEx/` containing three independent Spring Boot microservices, each with its own Gradle wrapper:

- **`micro/`** — OAuth2 Resource Server (port 8081) — this is the primary working directory
- **`gateway/`** — Spring Cloud Gateway / OAuth2 Client (port 8080)
- **`auth-server/`** — Spring Authorization Server / OIDC Provider (port 9000)

Each service is built and run independently; there is no root-level Gradle build.

## Build & Run Commands

Run all commands from the relevant service directory (e.g. `../micro`, `../gateway`, `../auth-server`):

```bash
./gradlew build          # Compile and package
./gradlew bootRun        # Run the service locally
./gradlew test           # Run tests
./gradlew clean build    # Clean rebuild
```

Start all three services to get a working system (order matters — auth-server must be up before gateway and micro):

```bash
cd ../auth-server && ./gradlew bootRun   # port 9000
cd ../micro       && ./gradlew bootRun   # port 8081
cd ../gateway     && ./gradlew bootRun   # port 8080
```

## Architecture

```
Browser → Gateway (8080) ──token relay──→ Micro (8081)
              │
              └──OAuth2 login──→ Auth-Server (9000)
```

**Auth-Server**: Spring Authorization Server issuing JWT access tokens via OIDC. Default credentials: `user` / `password`. Client: `oidc-client` / `iaka`.

**Gateway**: Acts as the OAuth2 client. Redirects unauthenticated users to auth-server login, then relays the access token downstream via `TokenRelayGatewayFilterFactory`.

**Micro**: Validates incoming JWTs against the auth-server's JWKS endpoint. Exposes reactive (WebFlux) endpoints via functional routing (`RouterFunction` + handler).

## Micro Service Endpoints

| Method | Path | Auth required | Handler |
|--------|------|---------------|---------|
| GET | `/api/greetings` | No | `GreetingsRoute` |
| GET | `/api/secret` | Yes | `ApiHandler` |
| GET | `/api/user` | Yes | `ApiHandler` — returns JWT principal info |

Security is configured in `SecConfig`: `/api/greetings` is open; everything else requires a valid JWT.

## Gateway Routes (`GatewayRouterConfig`)

- `/api/greetings/**` → micro (no token relay)
- `/api/secret/**` → micro (with token relay)
- `/api/**` → micro (with token relay, requires authentication)

## Environment Variables

| Variable | Service | Default |
|----------|---------|---------|
| `AUTH_EXTERNAL_ISSUER_URI` | micro | `http://localhost:9000` |
| `OIDC_ISSUER_URI` | gateway | `http://localhost:9000` |
| `GATEWAY_CLIENT_SECRET` | gateway | `iaka` |

## Tech Stack

- **Java 25**, **Spring Boot 4.0.5**, **Gradle 9.4.1** (Kotlin DSL)
- **Spring WebFlux** (reactive) for micro and gateway
- **Spring Security OAuth2** — Authorization Server, Resource Server, Client
- GraalVM native image support available (`./gradlew nativeCompile`)
