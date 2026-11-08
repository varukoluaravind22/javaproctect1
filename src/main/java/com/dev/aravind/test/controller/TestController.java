
package com.dev.aravind.test.controller;

import java.time.Instant;
import java.util.Map;
import java.util.StringJoiner;

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

    // Common HTML layout for all endpoints
    private String createPage(String title, String subtitle,
                              String icon, String content) {

        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport"
                      content="width=device-width, initial-scale=1.0">
                <title>%s | DevOps HQ</title>

                <style>
                    * {
                        box-sizing: border-box;
                    }

                    body {
                        margin: 0;
                        min-height: 100vh;
                        font-family: Arial, sans-serif;
                        color: #e2e8f0;
                        background:
                            radial-gradient(circle at top left,
                            #312e81, transparent 40%%),
                            linear-gradient(135deg,
                            #020617, #0f172a, #1e1b4b);
                    }

                    nav {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        flex-wrap: wrap;
                        gap: 15px;
                        padding: 20px 7%%;
                        background: rgba(15,23,42,0.85);
                        border-bottom: 1px solid #334155;
                    }

                    .brand {
                        font-size: 21px;
                        font-weight: bold;
                        color: #38bdf8;
                    }

                    nav a {
                        color: #cbd5e1;
                        text-decoration: none;
                        margin: 7px;
                        font-size: 13px;
                    }

                    nav a:hover {
                        color: #38bdf8;
                    }

                    main {
                        max-width: 1050px;
                        margin: 65px auto;
                        padding: 20px;
                    }

                    .hero {
                        text-align: center;
                        margin-bottom: 35px;
                    }

                    .icon {
                        font-size: 55px;
                        margin-bottom: 15px;
                    }

                    h1 {
                        font-size: clamp(30px, 5vw, 45px);
                        margin: 10px 0;
                        color: #f8fafc;
                    }

                    .subtitle {
                        color: #94a3b8;
                        font-size: 16px;
                    }

                    .card {
                        background: rgba(30,41,59,0.88);
                        border: 1px solid #334155;
                        border-radius: 18px;
                        padding: 30px;
                        box-shadow: 0 15px 45px
                            rgba(0,0,0,0.25);
                    }

                    .card h2 {
                        color: #38bdf8;
                        margin-top: 0;
                        font-size: 21px;
                    }

                    .items {
                        display: grid;
                        grid-template-columns:
                            repeat(auto-fit, minmax(220px, 1fr));
                        gap: 15px;
                    }

                    .item {
                        background: #0f172a;
                        padding: 18px;
                        border-radius: 12px;
                        border: 1px solid #334155;
                        overflow-wrap: anywhere;
                    }

                    .item strong {
                        display: block;
                        color: #94a3b8;
                        font-size: 12px;
                        margin-bottom: 9px;
                        text-transform: uppercase;
                    }

                    .item span {
                        color: #f8fafc;
                        font-size: 15px;
                    }

                    .status {
                        display: inline-block;
                        padding: 7px 14px;
                        background: rgba(34,197,94,0.15);
                        color: #4ade80;
                        border-radius: 20px;
                        font-size: 13px;
                        font-weight: bold;
                    }

                    footer {
                        text-align: center;
                        padding: 25px;
                        color: #64748b;
                        font-size: 13px;
                    }

                    @media(max-width: 600px) {
                        nav {
                            justify-content: center;
                        }

                        main {
                            margin-top: 35px;
                        }

                        .card {
                            padding: 20px;
                        }
                    }
                </style>
            </head>

            <body>

                <nav>
                    <div class="brand">⚡ DEVOPS HQ</div>

                    <div>
                        <a href="/devops">Home</a>
                        <a href="/devops/info">Info</a>
                        <a href="/devops/pipeline">Pipeline</a>
                        <a href="/devops/docker">Docker</a>
                        <a href="/devops/kubernetes">Kubernetes</a>
                        <a href="/devops/aws">AWS</a>
                        <a href="/devops/monitoring">Monitoring</a>
                        <a href="/devops/gitops">GitOps</a>
                        <a href="/devops/health">Health</a>
                    </div>
                </nav>

                <main>

                    <section class="hero">
                        <div class="icon">%s</div>
                        <h1>%s</h1>
                        <p class="subtitle">%s</p>
                    </section>

                    <section class="card">
                        <h2>System Information</h2>
                        <div class="items">
                            %s
                        </div>
                    </section>

                </main>

                <footer>
                    DevOps HQ | Spring Boot Application |
                    Powered by Java
                </footer>

            </body>
            </html>
            """.formatted(title, icon, title, subtitle, content);
    }

    // Creates an individual information card
    private String item(String label, String value) {

        return """
            <div class="item">
                <strong>%s</strong>
                <span>%s</span>
            </div>
            """.formatted(label, value);
    }

    // 1. DevOps Welcome Page
    @GetMapping(value = "/devops", produces = "text/html")
    public String devops() {

        logger.info("Received request for /devops");

        String content =
                item("Platform", "DevOps Engineering")
                + item("Role", "DevOps Engineer")
                + item("Level", "L1")
                + item("Status", "Active");

        logger.info("Successfully generated DevOps welcome page");

        return createPage(
                "Welcome Onboard",
                "Welcome to the DevOps Engineering Platform",
                "🚀",
                content
        );
    }

    // 2. DevOps Engineer Information
    @GetMapping(value = "/devops/info", produces = "text/html")
    public String devopsInfo() {

        logger.info("Fetching DevOps engineer information");

        String content =
                item("Role", "DevOps Engineer")
                + item("Level", "L1")
                + item("Status", "Active")
                + item("Skills",
                    "AWS, Docker, Kubernetes, Jenkins, Terraform, Linux")
                + item("Monitoring",
                    "Prometheus and Grafana")
                + item("Deployment", "GitOps");

        logger.info("DevOps engineer information retrieved successfully");

        return createPage(
                "Engineer Information",
                "Technical Skills and Engineering Profile",
                "👨‍💻",
                content
        );
    }

    // 3. CI/CD Pipeline
    @GetMapping(value = "/devops/pipeline", produces = "text/html")
    public String pipeline() {

        logger.info("Checking CI/CD pipeline status");

        String content =
                item("Source Code", "GitHub")
                + item("CI/CD Tool", "Jenkins")
                + item("Build Tool", "Gradle")
                + item("Code Analysis", "SonarQube")
                + item("Image Scanning", "Trivy")
                + item("Deployment", "Argo CD")
                + item("Pipeline Status", "SUCCESS");

        logger.info("CI/CD pipeline status retrieved successfully");

        return createPage(
                "CI/CD Pipeline",
                "Continuous Integration and Continuous Deployment",
                "🔄",
                content
        );
    }

    // 4. Docker Information
    @GetMapping(value = "/devops/docker", produces = "text/html")
    public String docker() {

        logger.info("Fetching Docker deployment information");

        String content =
                item("Platform", "Docker")
                + item("Image Repository", "varukoluaravind22/ci-cd")
                + item("Containerization", "Enabled")
                + item("Deployment Status", "Running");

        logger.info("Docker information retrieved successfully");

        return createPage(
                "Docker Environment",
                "Containerization and Image Management",
                "🐳",
                content
        );
    }

    // 5. Kubernetes Information
    @GetMapping(value = "/devops/kubernetes", produces = "text/html")
    public String kubernetes() {

        logger.info("Fetching Kubernetes deployment information");

        String content =
                item("Platform", "Kubernetes")
                + item("Deployment", "devops-website")
                + item("Namespace", "sit")
                + item("Orchestration", "Enabled")
                + item("Deployment Status", "Active");

        logger.info("Kubernetes deployment information retrieved successfully");

        return createPage(
                "Kubernetes Environment",
                "Container Orchestration and Deployment",
                "☸️",
                content
        );
    }

    // 6. AWS Cloud Information
    @GetMapping(value = "/devops/aws", produces = "text/html")
    public String aws() {

        logger.info("Fetching AWS cloud information");

        String content =
                item("Cloud Provider", "Amazon Web Services")
                + item("Compute", "EC2")
                + item("Container Service", "EKS")
                + item("Networking", "VPC")
                + item("Identity", "IAM")
                + item("Storage", "S3")
                + item("Database", "RDS")
                + item("Infrastructure", "Cloud");

        logger.info("AWS cloud information retrieved successfully");

        return createPage(
                "AWS Cloud Infrastructure",
                "Cloud Services and Infrastructure",
                "☁️",
                content
        );
    }

    // 7. Monitoring Information
    @GetMapping(value = "/devops/monitoring", produces = "text/html")
    public String monitoring() {

        logger.info("Fetching monitoring information");

        String content =
                item("Metrics Collection", "Prometheus")
                + item("Visualization", "Grafana")
                + item("Log Management", "Loki")
                + item("Log Collector", "Fluent Bit")
                + item("Monitoring Status", "Configured");

        logger.info("Monitoring information retrieved successfully");

        return createPage(
                "Monitoring and Logging",
                "Application Observability and Metrics",
                "📊",
                content
        );
    }

    // 8. GitOps Information
    @GetMapping(value = "/devops/gitops", produces = "text/html")
    public String gitops() {

        logger.info("Fetching GitOps deployment information");

        String content =
                item("GitOps Tool", "Argo CD")
                + item("Source Repository", "GitHub")
                + item("Application", "devops-website")
                + item("Namespace", "sit")
                + item("Deployment Strategy", "GitOps")
                + item("Status", "Configured");

        logger.info("GitOps information retrieved successfully");

        return createPage(
                "GitOps Deployment",
                "Automated Kubernetes Deployments",
                "🔁",
                content
        );
    }

    // 9. Application Health
    @GetMapping(value = "/devops/health", produces = "text/html")
    public String health() {

        logger.info("Application health endpoint accessed");

        String content =
                item("Application", "devops-website")
                + item("Application Status", "UP")
                + item("Timestamp", Instant.now().toString());

        logger.info("Application health response generated successfully");

        return createPage(
                "Application Health",
                "Application Availability and Status",
                "💚",
                content
        );
    }

    // 10. Warning Log
    @GetMapping(value = "/devops/warning", produces = "text/html")
    public String warning() {

        logger.warn("DevOps warning endpoint accessed");

        String content =
                item("Log Level", "WARN")
                + item("Message", "This endpoint generates a warning log")
                + item("Status", "Warning test completed");

        return createPage(
                "Warning Log",
                "Application Warning Log Testing",
                "⚠️",
                content
        );
    }

    // 11. Error Log Testing
    @GetMapping(value = "/devops/error", produces = "text/html")
    public ResponseEntity<String> error() {

        logger.error("DevOps error testing endpoint accessed");

        try {

            throw new RuntimeException(
                    "Simulated DevOps application error"
            );

        } catch (RuntimeException e) {

            logger.error("Simulated application error occurred", e);

            String content =
                    item("Application Status", "ERROR")
                    + item("HTTP Status", "500 Internal Server Error")
                    + item("Message", "Simulated application error");

            String page = createPage(
                    "Application Error",
                    "Simulated Error Log Testing",
                    "🚨",
                    content
            );

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(page);
        }
    }
}
