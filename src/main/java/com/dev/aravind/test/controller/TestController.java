
package com.dev.aravind.test.controller;

import java.time.Instant;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger =
            LoggerFactory.getLogger(TestController.class);

    // 1. DevOps Welcome Page
    @GetMapping(value = "/devops", produces = "text/html")
    public String devops() {

        logger.info("Received request for /devops");

        String response = """
            <html>
                <body style="
                    margin:0;
                    display:flex;
                    justify-content:center;
                    align-items:center;
                    height:100vh;
                    background:linear-gradient(
                        135deg,#0f172a,#1e293b,#312e81
                    );
                    font-family:Arial,sans-serif;
                ">

                    <div style="
                        text-align:center;
                        padding:40px;
                        border-radius:20px;
                        background:rgba(255,255,255,0.08);
                        box-shadow:0 8px 32px rgba(0,0,0,0.3);
                    ">

                        <h1 style="color:#f8fafc;font-size:55px;">
                            Welcome Onboard DevOps Engineer
                        </h1>

                        <h2 style="color:#38bdf8;letter-spacing:3px;">
                            DevOps L1
                        </h2>

                    </div>

                </body>
            </html>
            """;

        logger.info("Successfully generated DevOps welcome page");

        return response;
    }

    // 2. DevOps Engineer Information
    @GetMapping("/devops/info")
    public Map<String, Object> devopsInfo() {

        logger.info("Fetching DevOps engineer information");

        Map<String, Object> response = Map.of(
                "role", "DevOps Engineer",
                "level", "L1",
                "skills", new String[]{
                        "AWS",
                        "Docker",
                        "Kubernetes",
                        "Jenkins",
                        "Terraform",
                        "Linux",
                        "GitOps",
                        "Prometheus",
                        "Grafana"
                },
                "status", "Active"
        );

        logger.info("DevOps engineer information retrieved successfully");

        return response;
    }

    // 3. CI/CD Pipeline
    @GetMapping("/devops/pipeline")
    public Map<String, Object> pipeline() {

        logger.info("Checking CI/CD pipeline status");

        Map<String, Object> response = Map.of(
                "pipeline", "Jenkins CI/CD",
                "source", "GitHub",
                "build", "Gradle",
                "security", "SonarQube and Trivy",
                "deployment", "Argo CD",
                "status", "SUCCESS"
        );

        logger.info("CI/CD pipeline status retrieved successfully");

        return response;
    }

    // 4. Docker Information
    @GetMapping("/devops/docker")
    public Map<String, Object> docker() {

        logger.info("Fetching Docker deployment information");

        Map<String, Object> response = Map.of(
                "platform", "Docker",
                "image", "varukoluaravind22/ci-cd",
                "containerization", "Enabled",
                "status", "Running"
        );

        logger.info("Docker information retrieved successfully");

        return response;
    }

    // 5. Kubernetes Information
    @GetMapping("/devops/kubernetes")
    public Map<String, Object> kubernetes() {

        logger.info("Fetching Kubernetes deployment information");

        Map<String, Object> response = Map.of(
                "platform", "Kubernetes",
                "deployment", "devops-website",
                "namespace", "sit",
                "orchestration", "Enabled",
                "status", "Active"
        );

        logger.info("Kubernetes deployment information retrieved successfully");

        return response;
    }

    // 6. AWS Cloud Information
    @GetMapping("/devops/aws")
    public Map<String, Object> aws() {

        logger.info("Fetching AWS cloud information");

        Map<String, Object> response = Map.of(
                "cloud", "AWS",
                "services", new String[]{
                        "EC2",
                        "EKS",
                        "IAM",
                        "VPC",
                        "S3",
                        "RDS"
                },
                "infrastructure", "Cloud",
                "status", "Configured"
        );

        logger.info("AWS cloud information retrieved successfully");

        return response;
    }

    // 7. Monitoring Information
    @GetMapping("/devops/monitoring")
    public Map<String, Object> monitoring() {

        logger.info("Fetching monitoring information");

        Map<String, Object> response = Map.of(
                "monitoring", "Prometheus",
                "visualization", "Grafana",
                "logging", "Loki",
                "logCollector", "Fluent Bit",
                "status", "Configured"
        );

        logger.info("Monitoring information retrieved successfully");

        return response;
    }

    // 8. GitOps Information
    @GetMapping("/devops/gitops")
    public Map<String, Object> gitops() {

        logger.info("Fetching GitOps deployment information");

        Map<String, Object> response = Map.of(
                "tool", "Argo CD",
                "repository", "GitHub",
                "deployment", "devops-website",
                "namespace", "sit",
                "strategy", "GitOps",
                "status", "Configured"
        );

        logger.info("GitOps information retrieved successfully");

        return response;
    }

    // 9. Application Health
    @GetMapping("/devops/health")
    public Map<String, Object> health() {

        logger.info("Application health endpoint accessed");

        Map<String, Object> response = Map.of(
                "application", "devops-website",
                "status", "UP",
                "timestamp", Instant.now().toString()
        );

        logger.info("Application health response generated successfully");

        return response;
    }

    // 10. Warning Log
    @GetMapping("/devops/warning")
    public Map<String, Object> warning() {

        logger.warn("DevOps warning endpoint accessed");

        return Map.of(
                "message", "This endpoint generates a warning log",
                "level", "WARN"
        );
    }

    // 11. Error Log Testing
    @GetMapping("/devops/error")
    public ResponseEntity<Map<String, Object>> error() {

        logger.error("DevOps error testing endpoint accessed");

        try {

            throw new RuntimeException(
                    "Simulated DevOps application error"
            );

        } catch (RuntimeException e) {

            logger.error("Simulated application error occurred", e);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "status", "ERROR",
                            "message", "Simulated application error"
                    ));
        }
    }
}
