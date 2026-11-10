# pharmacy-service
**MS1 · Pharmacies** · Microservice individuel

| Responsable | Port | Base |
|---|---|---|
| Jihed Khlifi | 8081 | H2 |

## Rôle
Pharmacies (adresse, horaires, position), pharmacies de garde, recherche par distance, validation par l'administrateur.

## Interactions
- Appelé par stock-service et reservation-service (OpenFeign). S'il tombe : mode dégradé, sans le nom de la pharmacie.
- Événements : Aucun (service de référence).

## Contrat d'API
| Verbe | Endpoint | Codes |
|---|---|---|
| GET | `/api/v1/pharmacies?onDuty=true` | 200 |
| GET | `/api/v1/pharmacies?lat=&lng=` | 200 |
| GET | `/api/v1/pharmacies/{id}` | 200, 404 |
| POST | `/api/v1/pharmacies` | 201, 400, 403 |
| PUT | `/api/v1/pharmacies/{id}` | 200, 403, 404 |
| PATCH | `/api/v1/pharmacies/{id}` | 200, 403, 404 |
| DELETE | `/api/v1/pharmacies/{id}` | 204, 404 |

## Diagrammes
- [Cas d'utilisation](../../Documentation/Diagrams/MS1-Pharmacies/cas-utilisation.png)
- [Classes](../../Documentation/Diagrams/MS1-Pharmacies/classes.png)
- [Séquence](../../Documentation/Diagrams/MS1-Pharmacies/sequence.png)
- [Architecture](../../Documentation/Diagrams/MS1-Pharmacies/architecture.png)

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `pharmacy-service`.

Dépendances : Spring Web, Spring Data JPA, H2 Database, Validation, Eureka Discovery Client, Config Client, OAuth2 Resource Server.

Dans `application.properties` : `spring.application.name=pharmacy-service`, `server.port=8081`, `spring.config.import=optional:configserver:http://localhost:8888`.

Lancement : `mvn spring-boot:run` puis http://localhost:8081/swagger-ui.html
