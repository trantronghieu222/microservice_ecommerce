package com.shop.accountservice.service.impl;

import com.shop.accountservice.dto.request.AccountDTO;
import com.shop.accountservice.entity.Account;
import com.shop.accountservice.exception.custom.ResourceNotFoundException;
import com.shop.accountservice.repository.AccountRepository;
import com.shop.accountservice.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy tài khoản!"));
    }

    @Override
    public Account create(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, Account account) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
