
package com.dev.aravind.test.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // 1. DevOps Welcome Page
    @Test
    void testDevops() throws Exception {

        mockMvc.perform(get("/devops"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Welcome Onboard")
                ))
                .andExpect(content().string(
                        containsString("DEVOPS HQ")
                ));
    }

    // 2. DevOps Engineer Information
    @Test
    void testDevopsInfo() throws Exception {

        mockMvc.perform(get("/devops/info"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Engineer Information")
                ))
                .andExpect(content().string(
                        containsString("DevOps Engineer")
                ));
    }

    // 3. CI/CD Pipeline
    @Test
    void testPipeline() throws Exception {

        mockMvc.perform(get("/devops/pipeline"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("CI/CD Pipeline")
                ))
                .andExpect(content().string(
                        containsString("Jenkins")
                ))
                .andExpect(content().string(
                        containsString("SUCCESS")
                ));
    }

    // 4. Docker Information
    @Test
    void testDocker() throws Exception {

        mockMvc.perform(get("/devops/docker"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Docker Environment")
                ))
                .andExpect(content().string(
                        containsString("varukoluaravind22/ci-cd")
                ));
    }

    // 5. Kubernetes Information
    @Test
    void testKubernetes() throws Exception {

        mockMvc.perform(get("/devops/kubernetes"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Kubernetes Environment")
                ))
                .andExpect(content().string(
                        containsString("devops-website")
                ));
    }

    // 6. AWS Cloud Information
    @Test
    void testAws() throws Exception {

        mockMvc.perform(get("/devops/aws"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("AWS Cloud Infrastructure")
                ))
                .andExpect(content().string(
                        containsString("Amazon Web Services")
                ))
                .andExpect(content().string(
                        containsString("EKS")
                ));
    }

    // 7. Monitoring Information
    @Test
    void testMonitoring() throws Exception {

        mockMvc.perform(get("/devops/monitoring"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Monitoring and Logging")
                ))
                .andExpect(content().string(
                        containsString("Prometheus")
                ))
                .andExpect(content().string(
                        containsString("Grafana")
                ));
    }

    // 8. GitOps Information
    @Test
    void testGitops() throws Exception {

        mockMvc.perform(get("/devops/gitops"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("GitOps Deployment")
                ))
                .andExpect(content().string(
                        containsString("Argo CD")
                ));
    }

    // 9. Application Health
    @Test
    void testHealth() throws Exception {

        mockMvc.perform(get("/devops/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Application Health")
                ))
                .andExpect(content().string(
                        containsString("UP")
                ));
    }

    // 10. Warning Log
    @Test
    void testWarning() throws Exception {

        mockMvc.perform(get("/devops/warning"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Warning Log")
                ))
                .andExpect(content().string(
                        containsString("WARN")
                ));
    }

    // 11. Error Log Testing
    @Test
    void testError() throws Exception {

        mockMvc.perform(get("/devops/error"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentTypeCompatibleWith("text/html"))
                .andExpect(content().string(
                        containsString("Application Error")
                ))
                .andExpect(content().string(
                        containsString("Simulated application error")
                ));
    }
}
