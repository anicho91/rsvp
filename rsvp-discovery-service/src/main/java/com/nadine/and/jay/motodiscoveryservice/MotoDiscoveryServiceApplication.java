package com.nadine.and.jay.motodiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MotoDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotoDiscoveryServiceApplication.class, args);
    }

}
