package com.backend.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private Long quantity;
    private Double unitprice;
    @ManyToOne
    private Bill bill;

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = quantity*product.getPrice();
    }
}

