package com.app.ecom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();


    public  List<User> fetchAllUsers()
    {
        return userList;
    }

    public User fetchUsers(Long id)
    {
        for(User user: userList)
        {
            if(user.getId().equals(id))
            {
                return  user;
            }
        }
    return null;
    }

    public void addUser(User user)
    {
        userList.add(user);

    }
}
