package com.shop.gatewayservice.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/v3/api-docs")
public class SwaggerConfigController {
    private final DiscoveryClient discoveryClient;

    public SwaggerConfigController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/swagger-config")
    public Map<String, Object> swaggerConfig(ServerHttpRequest request) throws URISyntaxException {
        URI uri = request.getURI();
        String gatewayUrl = new URI(uri.getScheme(), uri.getAuthority(), null, null, null).toString();

        Map<String, Object> swaggerConfig = new HashMap<>();
        List<Map<String, String>> urls = new ArrayList<>();

        // Lấy danh sách các service từ DiscoveryClient
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            // Nếu service có OpenAPI, thêm vào danh sách Swagger
            urls.add(Map.of("url", gatewayUrl + "/v3/api-docs/" + service, "name", service));
        }

        swaggerConfig.put("urls", urls);
        return swaggerConfig;
    }
}
