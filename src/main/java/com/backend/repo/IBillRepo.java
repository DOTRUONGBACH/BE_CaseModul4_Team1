package com.backend.repo;

import com.backend.model.Account;
import com.backend.model.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBillRepo extends CrudRepository<Bill,Long> {
    List<Bill> findAllByAccount(Account account);
}
