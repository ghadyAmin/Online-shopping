package com.UserLog.User.service;
import java.util.List;

import com.UserLog.User.dto.UserDto;
import com.UserLog.User.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UserLog.User.entity.User;


public interface UserService {

//get user by email and pass word



    // Save operation
    ResponseEntity addUser(UserRequest user);

    // Read operation
    User findUserByEmailAndPassword(String email, String password);




    // Update operation
     public void updateUser(User user, String email,String password);

    // Delete operation
    public void deleteUserById(Long id);


}
