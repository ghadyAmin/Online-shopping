package com.UserLog.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserlogDataResponse {
    private String token;
    private String email;
}
