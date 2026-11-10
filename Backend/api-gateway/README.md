# api-gateway
**API Gateway** · Infrastructure

| Responsable | Port | Base |
|---|---|---|
| Jihed Khlifi | 8080 | – |

## Rôle
Point d'entrée unique du front-end : routage `lb://` vers les microservices, validation du jeton JWT Keycloak, CORS ; la route interne de stock-service n'est pas exposée.

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `api-gateway`.

Dépendances : Gateway, Eureka Discovery Client, Config Client, OAuth2 Resource Server.

Dans `application.properties` : `spring.application.name=api-gateway`, `server.port=8080`, `spring.config.import=optional:configserver:http://localhost:8888`.

Lancement : `mvn spring-boot:run`
