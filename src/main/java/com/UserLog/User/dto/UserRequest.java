package com.UserLog.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserRequest {
    private final String name;
    private final String email;
    private final String password;

}
