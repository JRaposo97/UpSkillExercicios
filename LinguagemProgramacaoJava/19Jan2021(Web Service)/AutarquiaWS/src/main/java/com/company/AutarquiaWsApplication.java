package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutarquiaWsApplication {
    public static void main(String[] args) {
        System.getProperties().put("server.port", 8181);
        SpringApplication.run(AutarquiaWsApplication.class, args);
    }

}
