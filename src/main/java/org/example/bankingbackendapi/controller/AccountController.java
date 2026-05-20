package org.example.bankingbackendapi.controller;

import org.example.bankingbackendapi.model.Account;
import org.example.bankingbackendapi.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<Account> getAccounts()
    {
        return accountRepository.findAll();
    }
    @PostMapping
    public Account createAccount(@RequestBody Account account)
    {
        return accountRepository.save(account);
    }
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id)
    {
        accountRepository.deleteById(id);
    }
}
