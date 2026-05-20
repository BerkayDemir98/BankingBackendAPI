package org.example.bankingbackendapi.repository;

import org.example.bankingbackendapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
