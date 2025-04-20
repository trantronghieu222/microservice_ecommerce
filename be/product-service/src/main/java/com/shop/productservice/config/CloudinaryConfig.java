package com.shop.productservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        final Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "ddkht2nse");
        config.put("api_key", "336776214826687");
        config.put("api_secret", "l7RbiO91wpdBoisfrxcpYjw7VJE");
        return new Cloudinary(config);
    }
}
