
package com.dev.aravind.test.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDevops() throws Exception {

        mockMvc.perform(get("/devops"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"));
    }

    @Test
    void testDevopsInfo() throws Exception {

        mockMvc.perform(get("/devops/info"))
                .andExpect(status().isOk());
    }

    @Test
    void testPipeline() throws Exception {

        mockMvc.perform(get("/devops/pipeline"))
                .andExpect(status().isOk());
    }

    @Test
    void testDocker() throws Exception {

        mockMvc.perform(get("/devops/docker"))
                .andExpect(status().isOk());
    }

    @Test
    void testKubernetes() throws Exception {

        mockMvc.perform(get("/devops/kubernetes"))
                .andExpect(status().isOk());
    }

    @Test
    void testAws() throws Exception {

        mockMvc.perform(get("/devops/aws"))
                .andExpect(status().isOk());
    }

    @Test
    void testMonitoring() throws Exception {

        mockMvc.perform(get("/devops/monitoring"))
                .andExpect(status().isOk());
    }

    @Test
    void testGitops() throws Exception {

        mockMvc.perform(get("/devops/gitops"))
                .andExpect(status().isOk());
    }

    @Test
    void testHealth() throws Exception {

        mockMvc.perform(get("/devops/health"))
                .andExpect(status().isOk());
    }

    @Test
    void testWarning() throws Exception {

        mockMvc.perform(get("/devops/warning"))
                .andExpect(status().isOk());
    }

    @Test
    void testError() throws Exception {

        mockMvc.perform(get("/devops/error"))
                .andExpect(status().isInternalServerError());
    }
}
