# Minecraft API - Backend

RESTful API built with Java 17, Spring Boot, and MySQL to manage player data for a Minecraft server.

## Architecture
Layered architecture (MVC):
- Model: JPA Entities.
- Repository: Spring Data JPA.
- Service: Business logic and rank validation.
- Controller: REST Endpoints.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven

## Endpoints
- GET /api/jugadores - List all players.
- GET /api/jugadores/{nombre} - Get a player by name.
- POST /api/jugadores - Save or update player data (consumed by the Minecraft plugin).