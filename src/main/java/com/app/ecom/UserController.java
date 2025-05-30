package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;// Note : RequiredArgsConstructor only generate constructor for final field.

    @GetMapping("/api/users")
    public List<User> getAllUsers(){

       return userService.fetchAllUsers();
    }


    @PostMapping(value = "/api/user")
    public String createUser(@RequestBody User user) {
            userService.addUser(user);
            return "User:"+ user.getFirstName()+ "added Successfully";
    }

}
