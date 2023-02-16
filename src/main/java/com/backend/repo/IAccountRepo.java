package com.backend.repo;

import com.backend.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAccountRepo extends CrudRepository<Account, Long> {
    Account findAccountByUserName(String username);

    @Query("SELECT a FROM Account a WHERE a.userName = :userName")
    Account findAccountByUsername(@Param("userName") String userName);

    @Query("SELECT a FROM Account a WHERE a.email = :email")
    Account findAccountByEmail(@Param("email") String email);
}
