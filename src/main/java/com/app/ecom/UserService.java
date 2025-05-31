package com.app.ecom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();


    public  List<User> fetchAllUsers()
    {
        return userList;
    }

    public Optional<User> fetchUsers(Long id)
    {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void addUser(User user)
    {
        userList.add(user);
    }

    public  boolean updteUser(Long id, User updatedUser)
    {
        return  userList.stream()
                .filter(user -> user.getId().equals(id)).findFirst().map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    return true;
                }).orElse(false);
    }
}
