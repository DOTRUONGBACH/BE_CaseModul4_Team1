package com.backend.repo;

import com.backend.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface IAccRepo extends CrudRepository<Account,Long> {
    Account findAccountByUserName(String username);
}
