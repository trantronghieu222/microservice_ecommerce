package com.shop.accountservice.service.impl;

import com.shop.accountservice.dto.request.AccountDTO;
import com.shop.accountservice.dto.request.AccountUpdateDTO;
import com.shop.accountservice.dto.response.AccountResponseDTO;
import com.shop.accountservice.entity.Account;
import com.shop.accountservice.exception.AppException;
import com.shop.accountservice.exception.ErrorCode;
import com.shop.accountservice.repository.AccountRepository;
import com.shop.accountservice.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public Account findExistingAccount(String username) {
        return accountRepository.findByUsername(username).orElse(null);
    }

    @Override
    public AccountResponseDTO findByUsername(String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        return modelMapper.map(account, AccountResponseDTO.class);
    }

    @Override
    public Account create(AccountDTO accountDTO) {
        Account existingAccount = findExistingAccount(accountDTO.getUsername());

        if (existingAccount != null) {
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        Account account = modelMapper.map(accountDTO, Account.class);

        // Mã hoá
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));

        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, AccountUpdateDTO accountUpdateDTO) {
        Account account = findById(id);
        modelMapper.map(accountUpdateDTO, account);
        account.setUsername(account.getUsername());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        account.setPassword(passwordEncoder.encode(accountUpdateDTO.getPassword()));

        return accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
        Account account = findById(id);
        account.setDeleted(true);
        accountRepository.save(account);
    }
}
