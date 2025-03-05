package com.shop.cartservice.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        String gatewayUrl = "http://localhost:8080"; // Thay đổi khi deploy AWS

        return new OpenAPI()
                .info(new Info()
                        .title("Cart Service API")
                        .version("1.0.0")
                        .description("This is a sample API for demonstration.")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .servers(List.of(
                        new Server().url(gatewayUrl + "/cart-service").description("API Gateway - Cart Service")
                ));
    }
}