package com.shop.accountservice.repository;

import com.shop.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
