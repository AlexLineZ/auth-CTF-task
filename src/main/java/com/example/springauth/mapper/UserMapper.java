package com.example.springauth.mapper;

import com.example.springauth.entity.User;
import com.example.springauth.enums.Role;
import com.example.springauth.model.RegisterBody;
import com.example.springauth.model.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User mapRegisterBodyToUser(RegisterBody body) {
        User user = new User();
        user.setPassword(body.password());
        user.setNickName(body.nickName());
        user.setRole(Role.USER);
        user.setEmail(body.email());
        user.setPhone(body.phone());
        return user;
    }

    public static UserResponse mapUserToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getNickName(),
                user.getEmail(),
                user.getPhone(),
                user.getRole(),
                user.getRegistrationDate(),
                user.getLastUpdateDate()
        );
    }
}