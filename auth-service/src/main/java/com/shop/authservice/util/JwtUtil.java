package com.shop.authservice.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.shop.authservice.common.Role;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "CLOCKSHOP_SECRET_KEY_SUPER_SECURE_64";

    public static String generateToken(String username, Role role) throws JOSEException {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("shop-auth-service")
                .expirationTime(new Date(System.currentTimeMillis() + 3600 * 1000))
//                .claim("role", role.name())
                .claim("roles", new String[]{role.name()})
                .build();

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        SignedJWT signedJWT = new SignedJWT(header, claimsSet);

        signedJWT.sign(new MACSigner(SECRET_KEY));

        return signedJWT.serialize();
    }
}
