package com.example.demo.controller;

import com.example.demo.dto.UserLogData;
import com.example.demo.dto.UserLogDataResponse;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.security.util.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="user/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    //Save operation
    @PostMapping("/registration")
    public User addUser(@RequestBody UserRequest user) {
        return userService.addUser(user);
    }


    //Get user LOG IN
    @PostMapping(value= "/login")
    public ResponseEntity fetchUserByEmail(@RequestBody UserLogData user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Invalid Email/password");
        }
        return ResponseEntity.ok().body(new UserLogDataResponse(jwtUtil.generateToken(user.getEmail()), user.getEmail()));

    }



    // Update operation
    @PutMapping("/put/{email}/{password}")
    public void updateUser(@RequestBody User user,
                           @PathVariable("email") String email,@PathVariable String password) {
        userService.updateUser(user, email,password);
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")

    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "Deleted Successfully";
    }
}