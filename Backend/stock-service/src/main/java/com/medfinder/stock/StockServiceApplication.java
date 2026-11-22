package com.medfinder.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * MS3 - Stocks et disponibilite (port 8083).
 */
@SpringBootApplication //démarre l'application Spring Boot
@EnableDiscoveryClient   // client Eureka (facultatif avec la dépendance, gardé pour la lisibilité)
public class StockServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);
    }
}
