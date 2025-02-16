package com.shop.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				// account-service
				.route("user-route", r -> r.path("/user/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("CircuitBreaker")
										.getFallbackUri()))
						.uri("lb://account-service"))
				// auth-service
				.route("auth-route", r -> r.path("/auth/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("CircuitBreaker")
										.getFallbackUri()))
						.uri("lb://auth-service"))
				// cart-service
				.route("cart-route", r -> r.path("/cart/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("CircuitBreaker")
										.getFallbackUri()))
						.uri("lb://cart-service"))
				// order-service
				.route("order-route", r -> r.path("/order/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("CircuitBreaker")
										.getFallbackUri()))
						.uri("lb://order-service"))
				// product
				.route("product-route", r -> r.path("/product/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("CircuitBreaker")
										.getFallbackUri()))
						.uri("lb://product-service"))
				// received
				.route("received-route", r -> r.path("/received/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("CircuitBreaker")
										.getFallbackUri()))
						.uri("lb://received-service"))

				///swagger ui
				.route("openapi", r -> r.path("/v3/api-docs/**")
						.filters(f -> f.rewritePath("/v3/api-docs/(?<service>.*)", "/${service}/v3/api-docs"))
						.uri("lb://gateway-service"))

				.build();
	}
}
