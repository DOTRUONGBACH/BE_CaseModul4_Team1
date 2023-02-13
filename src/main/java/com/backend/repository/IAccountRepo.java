package com.backend.repository;

import com.backend.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account, Long> {
    Account findAccountByUserName(String username);
}
