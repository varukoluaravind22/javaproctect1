
package com.dev.aravind.test.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDevops() throws Exception {

        mockMvc.perform(get("/devops"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString(
                                "Welcome Onboard DevOps Engineer"
                        )
                ));
    }

    @Test
    void testDevopsInfo() throws Exception {

        mockMvc.perform(get("/devops/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.role").value("DevOps Engineer"));
    }

    @Test
    void testPipeline() throws Exception {

        mockMvc.perform(get("/devops/pipeline"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"));
    }

    @Test
    void testDocker() throws Exception {

        mockMvc.perform(get("/devops/docker"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.platform").value("Docker"));
    }

    @Test
    void testKubernetes() throws Exception {

        mockMvc.perform(get("/devops/kubernetes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.platform").value("Kubernetes"));
    }

    @Test
    void testAws() throws Exception {

        mockMvc.perform(get("/devops/aws"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cloud").value("AWS"));
    }

    @Test
    void testMonitoring() throws Exception {

        mockMvc.perform(get("/devops/monitoring"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.monitoring").value("Prometheus"));
    }

    @Test
    void testGitops() throws Exception {

        mockMvc.perform(get("/devops/gitops"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tool").value("Argo CD"));
    }

    @Test
    void testHealth() throws Exception {

        mockMvc.perform(get("/devops/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void testWarning() throws Exception {

        mockMvc.perform(get("/devops/warning"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.level").value("WARN"));
    }

    @Test
    void testError() throws Exception {

        mockMvc.perform(get("/devops/error"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.status").value("ERROR"));
    }
}
