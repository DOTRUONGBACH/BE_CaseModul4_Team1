package com.backend.model.dto;

import com.backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountToken {
    private String userName;
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
    private String avatar;
    private String token;
    private Role role;
}
