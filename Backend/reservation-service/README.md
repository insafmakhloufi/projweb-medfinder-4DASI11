# reservation-service
**MS4 · Réservations et alertes** · Microservice individuel

| Responsable | Port | Base |
|---|---|---|
| Insaf Makhloufi | 8084 | MySQL |

## Rôle
Réservations et codes de retrait, suivi des états, expiration automatique, alertes de retour en stock.

## Interactions
- Appelle medicine-service, pharmacy-service puis stock-service. Si stock-service tombe : réservation refusée (503), rien n'est enregistré.
- Événements : Publie `reservation.events`, `alert.triggered`, `reservation.released` ; reçoit `stock.replenished`.

## Contrat d'API
| Verbe | Endpoint | Codes |
|---|---|---|
| POST | `/api/v1/reservations` | 201, 409, 503 |
| GET | `/api/v1/reservations?status=` | 200 |
| GET | `/api/v1/reservations/{id}` | 200, 403, 404 |
| PATCH | `/api/v1/reservations/{id}` | 200, 403, 409 |
| POST | `/api/v1/alerts` | 201, 409 |
| GET | `/api/v1/alerts` | 200 |
| DELETE | `/api/v1/alerts/{id}` | 204, 404 |

## Diagrammes
- [Cas d'utilisation](../../Documentation/Diagrams/MS4-Reservations/cas-utilisation.png)
- [Classes](../../Documentation/Diagrams/MS4-Reservations/classes.png)
- [Séquence](../../Documentation/Diagrams/MS4-Reservations/sequence.png)
- [Architecture](../../Documentation/Diagrams/MS4-Reservations/architecture.png)

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `reservation-service`.

Dépendances : Spring Web, Spring Data JPA, MySQL Driver, Validation, Eureka Discovery Client, Config Client, OAuth2 Resource Server, OpenFeign, Resilience4J, Cloud Stream + RabbitMQ.

Dans `application.properties` : `spring.application.name=reservation-service`, `server.port=8084`, `spring.config.import=optional:configserver:http://localhost:8888`.

Lancement : `mvn spring-boot:run` puis http://localhost:8084/swagger-ui.html
