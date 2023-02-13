package com.backend.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;
    @ManyToOne
    private Bill bill;

}

