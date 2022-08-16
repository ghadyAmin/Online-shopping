package com.example.demo.service;


import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;

public interface UserService {

//get user by email and pass word



    // Save operation
    User addUser(UserRequest user);

    // Read operation
    User findUserByEmailAndPassword(String email, String password);




    // Update operation
    public void updateUser(User user, String email,String password);

    // Delete operation
    public void deleteUserById(Long id);


}
