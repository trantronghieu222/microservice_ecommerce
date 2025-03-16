package com.shop.authservice.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.shop.authservice.common.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret-key}")
    private String secretKey;

    public String generateToken(Integer id, Role role) throws JOSEException {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
//                .subject(username)
                .issuer("shop-auth-service")
                .expirationTime(new Date(System.currentTimeMillis() + 3600 * 1000))
//                .claim("role", role.name())
                .claim("roles", new String[]{role.name()})
                .claim("id", id)
                .build();

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        SignedJWT signedJWT = new SignedJWT(header, claimsSet);

        signedJWT.sign(new MACSigner(secretKey));

        return signedJWT.serialize();
    }
}
