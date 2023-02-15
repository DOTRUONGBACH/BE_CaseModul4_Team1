package com.backend.repo;

import com.backend.model.BillDetail;
import org.springframework.data.repository.CrudRepository;

public interface IBillDetail extends CrudRepository<BillDetail,Long> {
}
