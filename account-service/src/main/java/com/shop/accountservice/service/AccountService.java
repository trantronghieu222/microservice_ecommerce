package com.shop.accountservice.service;

import com.shop.accountservice.dto.request.AccountDTO;
import com.shop.accountservice.dto.request.AccountUpdateDTO;
import com.shop.accountservice.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(Integer id);

    Account findExistingAccount(String username);

    Account create(AccountDTO account);

    Account update(Integer id, AccountUpdateDTO accountUpdateDTO);

    void delete(Integer id);
}
