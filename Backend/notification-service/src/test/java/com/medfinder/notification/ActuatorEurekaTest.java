package com.medfinder.notification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Les tests ne touchent pas à MongoDB : son contrôle de santé est désactivé ici seulement. */
@SpringBootTest(properties = {"eureka.client.enabled=false", "management.health.mongo.enabled=false"})   // pas de serveur Eureka pendant les tests
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ActuatorEurekaTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void helloEndpoint() throws Exception {
        mvc.perform(get("/api/v1/notifications/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("hello I'm notification-service"));
    }

    @Test
    void actuatorHealth() throws Exception {
        mvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void actuatorInfo() throws Exception {
        mvc.perform(get("/actuator/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.app.name").value("notification-service"))
                .andExpect(jsonPath("$.app.team").value("GenerationZ"));
    }

    @Test
    void actuatorMetrics() throws Exception {
        mvc.perform(get("/actuator/metrics")).andExpect(status().isOk());
        mvc.perform(get("/actuator/metrics/jvm.memory.used")).andExpect(status().isOk());
    }

    @Test
    void actuatorLoggersChangeLevelAtRuntime() throws Exception {
        mvc.perform(post("/actuator/loggers/com.medfinder.notification").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"configuredLevel\":\"DEBUG\"}"))
                .andExpect(status().isNoContent());
        mvc.perform(get("/actuator/loggers/com.medfinder.notification"))
                .andExpect(jsonPath("$.configuredLevel").value("DEBUG"));
    }
}
