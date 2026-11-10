# eureka-server
**Eureka Server** · Infrastructure

| Responsable | Port | Base |
|---|---|---|
| Insaf Makhloufi | 8761 | – |

## Rôle
Registre des services : chaque microservice s'y enregistre ; la Gateway et OpenFeign le découvrent par son nom.

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `eureka-server`.

Dépendances : Eureka Server.

Dans `application.properties` : `spring.application.name=eureka-server`, `server.port=8761`, `spring.config.import=optional:configserver:http://localhost:8888`.

Lancement : `mvn spring-boot:run`
