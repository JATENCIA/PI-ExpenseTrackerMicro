package com.microservice.expenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceExpensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceExpensesApplication.class, args);
    }

}
