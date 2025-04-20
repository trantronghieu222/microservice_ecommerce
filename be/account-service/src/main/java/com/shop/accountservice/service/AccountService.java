package com.shop.accountservice.service;

import com.shop.accountservice.dto.request.AccountDTO;
import com.shop.accountservice.dto.request.AccountUpdateDTO;
import com.shop.accountservice.dto.request.RegisterDTO;
import com.shop.accountservice.dto.response.AccountResponseDTO;
import com.shop.accountservice.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    Account findById(Integer id);

    Account findExistingAccount(String username);

    AccountResponseDTO findByUsername(String username);

    Account create(AccountDTO account);

    void register(RegisterDTO register);

    Account update(Integer id, AccountUpdateDTO accountUpdateDTO);

    void delete(Integer id);
}
