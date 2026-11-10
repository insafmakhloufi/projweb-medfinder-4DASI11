# medicine-service
**MS2 · Catalogue des médicaments** · Microservice individuel

| Responsable | Port | Base |
|---|---|---|
| Abdelhamid Ayadi | 8082 | H2 |

## Rôle
Médicaments et catégories, recherche par nom ou molécule active, génériques, indication d'ordonnance.

## Interactions
- Appelé par stock-service et reservation-service. S'il tombe : ajout au stock et réservation refusés (503).
- Événements : Aucun (service de référence).

## Contrat d'API
| Verbe | Endpoint | Codes |
|---|---|---|
| GET | `/api/v1/medicines?q=&page=` | 200 |
| GET | `/api/v1/medicines/{id}` | 200, 404 |
| GET | `/api/v1/medicines/{id}/alternatives` | 200, 404 |
| POST | `/api/v1/medicines` | 201, 400, 409 |
| PUT | `/api/v1/medicines/{id}` | 200, 404 |
| DELETE | `/api/v1/medicines/{id}` | 204, 404 |
| GET | `/api/v1/categories` | 200 |
| POST | `/api/v1/categories` | 201, 409 |

## Diagrammes
- [Cas d'utilisation](../../Documentation/Diagrams/MS2-Medicaments/cas-utilisation.png)
- [Classes](../../Documentation/Diagrams/MS2-Medicaments/classes.png)
- [Séquence](../../Documentation/Diagrams/MS2-Medicaments/sequence.png)
- [Architecture](../../Documentation/Diagrams/MS2-Medicaments/architecture.png)

## Initialisation
Créer le projet sur https://start.spring.io : Maven, Java 17, Spring Boot 3.x, group `com.medfinder`, artifact `medicine-service`.

Dépendances : Spring Web, Spring Data JPA, H2 Database, Validation, Eureka Discovery Client, Config Client, OAuth2 Resource Server.

Dans `application.properties` : `spring.application.name=medicine-service`, `server.port=8082`, `spring.config.import=optional:configserver:http://localhost:8888`.

Lancement : `mvn spring-boot:run` puis http://localhost:8082/swagger-ui.html
