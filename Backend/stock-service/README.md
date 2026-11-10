# stock-service
**MS3 · Stocks** · Microservice individuel

| Responsable | Port | Base |
|---|---|---|
| Ferdaouas Oueslati | 8083 | H2 |

## Rôle
Stock de chaque médicament par pharmacie (quantité, prix, seuil), réapprovisionnement et historique, réservation d'unités sans survente.

## Interactions
- Appelle pharmacy-service et medicine-service ; appelé par reservation-service. Si pharmacy-service tombe : stocks sans le détail des pharmacies.
- Événements : Publie `stock.replenished` ; reçoit `reservation.released`.

## Contrat d'API
| Verbe | Endpoint | Codes |
|---|---|---|
| GET | `/api/v1/stocks?medicineId=9` | 200 |
| GET | `/api/v1/stocks?pharmacyId=1` | 200 |
| POST | `/api/v1/stocks` | 201, 403, 409 |
| PATCH | `/api/v1/stocks/{id}` | 200, 403, 404 |
| POST | `/api/v1/stocks/{id}/movements` | 201, 403, 404 |
| DELETE | `/api/v1/stocks/{id}` | 204, 403 |
| POST | `/api/v1/stocks/internal/reservations (interne)` | 201, 409 |

## Diagrammes
- [Cas d'utilisation](../../Documentation/Diagrams/MS3-Stocks/cas-utilisation.png)
- [Classes](../../Documentation/Diagrams/MS3-Stocks/classes.png)
- [Séquence](../../Documentation/Diagrams/MS3-Stocks/sequence.png)
- [Architecture](../../Documentation/Diagrams/MS3-Stocks/architecture.png)

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `stock-service`.

Dépendances : Spring Web, Spring Data JPA, H2 Database, Validation, Eureka Discovery Client, Config Client, OAuth2 Resource Server, OpenFeign, Resilience4J, Cloud Stream + RabbitMQ.

Dans `application.properties` : `spring.application.name=stock-service`, `server.port=8083`, `spring.config.import=optional:configserver:http://localhost:8888`.

Lancement : `mvn spring-boot:run` puis http://localhost:8083/swagger-ui.html
