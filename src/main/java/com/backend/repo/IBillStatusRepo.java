package com.backend.repo;

import com.backend.model.BillStatus;
import org.springframework.data.repository.CrudRepository;

public interface IBillStatusRepo extends CrudRepository<BillStatus,Long> {
}
