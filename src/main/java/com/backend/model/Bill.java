package com.backend.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Double Total;
    @OneToOne
    private Cart cart;
    @ManyToOne
    private BillStatus billStatus;

    @ManyToOne
    private Account account;
}