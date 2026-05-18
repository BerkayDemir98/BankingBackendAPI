package org.example.bankingbackendapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.ResolutionException;

@RestController
public class AccountController {
    @GetMapping("/api/accounts")
    public String AccountController() {
        return "Servus";
    }
}
