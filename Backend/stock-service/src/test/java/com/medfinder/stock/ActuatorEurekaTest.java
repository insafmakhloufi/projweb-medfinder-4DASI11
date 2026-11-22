package com.medfinder.stock;

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

@SpringBootTest(properties = "eureka.client.enabled=false")   // pas de serveur Eureka pendant les tests
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ActuatorEurekaTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void helloEndpoint() throws Exception {
        mvc.perform(get("/api/v1/stocks/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("hello I'm stock-service"));
    }

    @Test
    void actuatorHealth() throws Exception {
        mvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.components.db.status").value("UP"));
    }

    @Test
    void actuatorInfo() throws Exception {
        mvc.perform(get("/actuator/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.app.name").value("stock-service"))
                .andExpect(jsonPath("$.app.team").value("GenerationZ"));
    }

    @Test
    void actuatorMetrics() throws Exception {
        mvc.perform(get("/actuator/metrics")).andExpect(status().isOk());
        mvc.perform(get("/actuator/metrics/jvm.memory.used")).andExpect(status().isOk());
    }

    @Test
    void actuatorLoggersChangeLevelAtRuntime() throws Exception {
        mvc.perform(post("/actuator/loggers/com.medfinder.stock").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"configuredLevel\":\"DEBUG\"}"))
                .andExpect(status().isNoContent());
        mvc.perform(get("/actuator/loggers/com.medfinder.stock"))
                .andExpect(jsonPath("$.configuredLevel").value("DEBUG"));
    }
}
