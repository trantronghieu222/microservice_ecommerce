package com.shop.accountservice.repository;

import com.shop.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByAndIsDeletedFalse();

    Optional<Account> findByUsername(String username);
}
