package org.example.bankingbackendapi.controller;

import org.example.bankingbackendapi.dto.TransferRequest;
import org.example.bankingbackendapi.model.Transaction;
import org.example.bankingbackendapi.repository.TransactionRepository;
import org.example.bankingbackendapi.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;
    private final TransactionRepository transactionRepository;

    public TransferController(TransferService transferService, TransactionRepository transactionRepository) {
        this.transferService = transferService;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping
    public String transfer(@RequestBody TransferRequest request) {
        transferService.transfer(request);
        return "Transfer successful";
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}
