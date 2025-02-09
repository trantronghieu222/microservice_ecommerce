package com.shop.authservice.repository;

import com.shop.authservice.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Integer> {
    Boolean existsByUsername(String username);
}
