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
import org.springframework.web.bind.annotation.*;

import com.UserLog.User.entity.User;
import com.UserLog.User.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/user/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    //Save operation
    @PostMapping("/registration")
    public ResponseEntity addUser(@RequestBody UserRequest user) {
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
