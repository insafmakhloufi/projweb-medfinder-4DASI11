# notification-service
**MS5 · Notifications et statistiques (commun)** · Microservice commun

| Responsable | Port | Base |
|---|---|---|
| Toute l'équipe (pilotage : Ferdaouas Oueslati) | 8085 | MongoDB |

## Rôle
Écoute les événements, crée les notifications des patients et pharmaciens, journalise les événements, calcule les statistiques.

## Interactions
- Aucun appel sortant. S'il tombe : les messages attendent dans RabbitMQ.
- Événements : Reçoit `stock.replenished`, `alert.triggered`, `reservation.events`.

## Contrat d'API
| Verbe | Endpoint | Codes |
|---|---|---|
| GET | `/api/v1/notifications?read=false` | 200, 401 |
| PATCH | `/api/v1/notifications/{id}` | 200, 403, 404 |
| PATCH | `/api/v1/notifications` | 204 |
| GET | `/api/v1/events?type=` | 200, 403 |
| GET | `/api/v1/statistics` | 200, 403 |

## Diagrammes
- [Cas d'utilisation](../../Documentation/Diagrams/MS5-Notifications/cas-utilisation.png)
- [Classes](../../Documentation/Diagrams/MS5-Notifications/classes.png)
- [Séquence](../../Documentation/Diagrams/MS5-Notifications/sequence.png)
- [Architecture](../../Documentation/Diagrams/MS5-Notifications/architecture.png)

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `notification-service`.

Dépendances : Spring Web, Spring Data MongoDB, Eureka Discovery Client, Config Client, OAuth2 Resource Server, Cloud Stream + RabbitMQ.

Dans `application.properties` : `spring.application.name=notification-service`, `server.port=8085`, `spring.config.import=optional:configserver:http://localhost:8888`.

Lancement : `mvn spring-boot:run` puis http://localhost:8085/swagger-ui.html
