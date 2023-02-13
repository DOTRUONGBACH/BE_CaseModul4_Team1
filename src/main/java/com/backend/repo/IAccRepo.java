package com.backend.repo;

import com.backend.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccRepo extends CrudRepository<Account,Long> {
}
