package com.example.springauth.model;

import com.example.springauth.enums.Role;

import java.util.Date;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String nickName,
        String email,
        String phone,
        Role role,
        Date registrationDate,
        Date lastUpdateDate
) { }
