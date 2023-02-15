package com.backend.model;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String passWord;
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
    private String avatar;

    @ManyToOne
    private Role role;

    public Account() {
    }
}
