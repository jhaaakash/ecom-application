package com.app.ecom.controller;

import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.User;
import com.app.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;// Note : RequiredArgsConstructor only generate constructor for final field.

    @GetMapping("/api/users")
    //Fetching All user
    public ResponseEntity<List<UserResponse>> getAllUsers(){
           //return  ResponseEntity.ok(userService.fetchAllUsers());
       return  new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    //Fetching an Specific user
    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> getUsers(@PathVariable Long id){
        return userService.fetchUsers(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    //Creating a new User
    @PostMapping(value = "/api/user")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
            userService.addUser(userRequest);
            return ResponseEntity.ok("User: added Successfully");
    }

    //Updating an User
    @PutMapping("/api/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id , @RequestBody UserRequest updatedUserRequest)
    {
        boolean updated = userService.updteUser(id, updatedUserRequest);
        if(updated)
        {
            return ResponseEntity.ok("User updated Successfully");
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
}
