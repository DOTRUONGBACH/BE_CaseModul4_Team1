package com.backend.service;

import com.backend.repo.IBillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailService {
    @Autowired
    IBillDetail iBillDetail;

}
