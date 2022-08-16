package com.UserLog.User.dto;

import lombok.*;

@Setter
@Getter

@NoArgsConstructor
@ToString
public class UserRequest {
    private  String name;
    private  String email;
    private  String password;

    UserRequest(String name,String email,String password)
    {
        this.name=name;
        this.email=email;
        this.password=password;
    }

}
