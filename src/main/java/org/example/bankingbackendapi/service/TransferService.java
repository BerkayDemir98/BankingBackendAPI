package org.example.bankingbackendapi.service;

import lombok.RequiredArgsConstructor;
import org.example.bankingbackendapi.dto.TransferRequest;
import org.example.bankingbackendapi.model.Account;
import org.example.bankingbackendapi.repository.AccountRepository;
import org.example.bankingbackendapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public void transfer(TransferRequest request){
        Account from = accountRepository
                .findById(request.fromAccountId())
                .orElseThrow(()-> new RuntimeException("Sender account not found"));

        Account to = accountRepository
                .findById(request.toAccountId())
                .orElseThrow(()-> new RuntimeException("Receiver account not found"));

        if (from.getBalance().compareTo(request.amount()) < 0) {
            throw new RuntimeException("Not enough balance");
        }

        from.setBalance(
                from.getBalance().subtract(request.amount())
        );
        to.setBalance(
                to.getBalance().add(request.amount())
        );

        accountRepository.save(from);
        accountRepository.save(to);

    }

}
