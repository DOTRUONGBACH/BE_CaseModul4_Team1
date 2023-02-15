package com.backend.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Cart cart;
    @ManyToOne
    private BillStatus billStatus;
    @ManyToOne
    private Account account;
    private Date date;
}

