//package com.backend.model;
//
//import javax.persistence.*;
//import lombok.Data;
//
//import java.util.Date;
//
//@Data
//@Entity
//public class Bill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Date date;
//    private Double Total;
//    @ManyToOne
//    private BillStatus billStatus;
//    @ManyToOne
//    private Account account;
//}