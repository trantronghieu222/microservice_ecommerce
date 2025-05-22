package com.shop.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String SECRET_KEY = "CLOCKSHOP_SECRET_KEY_SUPER_SECURE_64";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/actuator/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/product", "/product/{id}", "/product/search-paging", "/product/check-stock/{id}", "/supplier", "/supplier/{id}", "/productType", "/productType/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/product", "/product/upload-image/{id}", "/product/upload-image-cloud/{id}", "/supplier", "/productType").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/product", "/supplier", "/productType").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/product/{id}", "/supplier", "/productType").hasRole("ADMIN")
                        //
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())))
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
        grantedAuthoritiesConverter.setAuthoritiesClaimName("roles");

        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return authenticationConverter;
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        byte[] keyBytes = SECRET_KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKeySpec).build();
    }
}
