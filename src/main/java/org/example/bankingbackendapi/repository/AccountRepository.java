package org.example.bankingbackendapi.repository;

import org.example.bankingbackendapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
