package com.medfinder.eureka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EurekaServerApplicationTests {

    @Autowired
    private TestRestTemplate rest;

    @Test
    void dashboardIsServed() {
        ResponseEntity<String> res = rest.getForEntity("/", String.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getBody()).contains("Eureka");
    }

    @Test
    void registryApiIsExposed() {
        assertThat(rest.getForEntity("/eureka/apps", String.class).getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
