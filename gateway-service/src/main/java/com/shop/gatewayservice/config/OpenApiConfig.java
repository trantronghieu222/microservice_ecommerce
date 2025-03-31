package com.shop.gatewayservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiConfig {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Bean
    public OpenAPI customOpenAPI() {
        String gatewayUrl = "http://localhost:8080"; // Đổi thành domain khi deploy AWS

        List<Server> servers = new ArrayList<>();

        // Lấy danh sách service từ DiscoveryClient
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            servers.add(new Server().url(gatewayUrl + "/" + service).description("API Gateway - " + service));
        }

        return new OpenAPI()
                .info(new Info()
                        .title("Microservices API")
                        .version("1.0")
                        .description("API Documentation for all services"))
                .servers(servers);
    }
}