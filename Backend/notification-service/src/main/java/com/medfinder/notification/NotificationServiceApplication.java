package com.medfinder.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * MS5 - Notifications et messagerie (port 8085).
 */
@SpringBootApplication
@EnableDiscoveryClient   // client Eureka (facultatif avec la dépendance, gardé pour la lisibilité)
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
}
