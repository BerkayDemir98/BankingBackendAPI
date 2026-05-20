package org.example.bankingbackendapi.controller;

import org.example.bankingbackendapi.dto.TransferRequest;
import org.example.bankingbackendapi.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public String transfer(@RequestBody TransferRequest request) {
        transferService.transfer(request);
        return "Transfer successful";
    }
}
