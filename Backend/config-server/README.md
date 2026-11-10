# config-server
**Config Server** · Infrastructure

| Responsable | Port | Base |
|---|---|---|
| Insaf Makhloufi | 8888 | – |

## Rôle
Configuration centralisée de tous les services (ports, bases, RabbitMQ, Eureka), avec les profils `dev` et `docker`.

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `config-server`.

Dépendances : Config Server.

Dans `application.properties` : `spring.application.name=config-server`, `server.port=8888`.

Lancement : `mvn spring-boot:run`
