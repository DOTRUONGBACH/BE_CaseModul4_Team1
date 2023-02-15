package com.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private Long amount = 1L;
    @ManyToOne
    private Cart cart;

}
