package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;// Note : RequiredArgsConstructor only generate constructor for final field.

    @GetMapping("/api/users")
    //Fetching All user
    public ResponseEntity<List<User>> getAllUsers(){
           //return  ResponseEntity.ok(userService.fetchAllUsers());
       return  new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    //Fetching an Specific user
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id){
        return userService.fetchUsers(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    //Creating a new User
    @PostMapping(value = "/api/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
            userService.addUser(user);
            return ResponseEntity.ok("User:"+ user.getFirstName()+ " added Successfully");
    }

    //Updating an User
    @PutMapping("/api/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id , @RequestBody User updatedUser)
    {
        boolean updated = userService.updteUser(id, updatedUser);
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
