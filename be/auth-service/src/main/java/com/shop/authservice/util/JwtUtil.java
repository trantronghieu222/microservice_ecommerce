package com.shop.authservice.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.shop.authservice.common.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret-key}")
    private String secretKey;

    private static final long ACCESS_TOKEN_EXPIRATION = 3600 * 1000; // 1 giờ
    private static final long REFRESH_TOKEN_EXPIRATION = 7 * 24 * 3600 * 1000; // 7 ngày

    public String generateToken(Integer id, Role role) throws JOSEException {
        return generateJwtToken(id, role, ACCESS_TOKEN_EXPIRATION);
    }

    public String generateRefreshToken(Integer id, Role role) throws JOSEException {
        return generateJwtToken(id, role, REFRESH_TOKEN_EXPIRATION);
    }

    private String generateJwtToken(Integer id, Role role, long expirationTime) throws JOSEException {
        JWTClaimsSet.Builder claimsBuilder = new JWTClaimsSet.Builder()
                .issuer("shop-auth-service")
                .expirationTime(new Date(System.currentTimeMillis() + expirationTime))
                .claim("id", id);

        if (role != null) {
            claimsBuilder.claim("roles", new String[]{role.name()}); // Sửa lại roles thành mảng
        }

        JWTClaimsSet claimsSet = claimsBuilder.build();
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        SignedJWT signedJWT = new SignedJWT(header, claimsSet);
        signedJWT.sign(new MACSigner(secretKey.getBytes()));

        return signedJWT.serialize();
    }

    public boolean validateToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            Date expiration = signedJWT.getJWTClaimsSet().getExpirationTime();
            return expiration.after(new Date()) && signedJWT.verify(new MACVerifier(secretKey.getBytes()));
        } catch (JOSEException | ParseException e) {
            return false;
        }
    }

    public Integer extractId(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return ((Long) signedJWT.getJWTClaimsSet().getClaim("id")).intValue();
        } catch (ParseException e) {
            return null;
        }
    }

    public String[] extractRoles(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return signedJWT.getJWTClaimsSet().getStringArrayClaim("roles");
        } catch (ParseException e) {
            return null;
        }
    }
}