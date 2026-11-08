
package com.dev.aravind.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TestApplication {

    private static final Logger logger =
            LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {

        logger.info("Starting DevOps Website Application");

        try {

            SpringApplication.run(TestApplication.class, args);

            logger.info("DevOps Website Application started successfully");

        } catch (Exception e) {

            logger.error("Failed to start DevOps Website Application", e);

            throw e;
        }
    }

    @EventListener
    public void applicationShutdown(ContextClosedEvent event) {

        logger.warn("DevOps Website Application is shutting down");
    }
}
