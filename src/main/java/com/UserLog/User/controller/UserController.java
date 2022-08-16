package com.UserLog.User.controller;
import java.util.List;

import com.UserLog.User.Security.util.JwtUtil;
import com.UserLog.User.dto.UserDto;
import com.UserLog.User.dto.UserRequest;
import com.UserLog.User.dto.UserlogData;
import com.UserLog.User.dto.UserlogDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserLog.User.entity.User;
import com.UserLog.User.service.UserService;



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
    public UserDto addUser(@RequestBody UserRequest user) {
       return userService.addUser(user);
    }


    //Get user LOG IN
    @PostMapping(value= "/login")
    public ResponseEntity fetchUserByEmail(@RequestBody UserlogData user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Invalid Email/password");
        }
        return ResponseEntity.ok().body(new UserlogDataResponse(jwtUtil.generateToken(user.getEmail()), user.getEmail()));

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
