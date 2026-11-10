# Frontend

Application React (Vite) : interface patient, pharmacien et administrateur. Elle n'appelle que l'API Gateway (http://localhost:8080) et se connecte via Keycloak.

## Pages prévues
| Page | Rôle | Microservice |
|---|---|---|
| Recherche de médicaments et pharmacies | Visiteur | MS2, MS3, MS1 |
| Mes réservations, mes alertes | Patient | MS4 |
| Mes notifications | Patient, pharmacien | MS5 |
| Ma pharmacie, mes stocks, réservations reçues | Pharmacien | MS1, MS3, MS4 |
| Validation des pharmacies, catalogue, statistiques | Administrateur | MS1, MS2, MS5 |

Chaque membre développe les pages de son microservice.

## Initialisation
`npm create vite@latest . -- --template react` puis `npm install` et `npm run dev` (http://localhost:5173).
