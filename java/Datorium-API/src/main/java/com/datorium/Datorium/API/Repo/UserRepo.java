package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTO.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {

    private final List<User> users = new ArrayList<>(); //Mocked db

    public int add(User user) {
        users.add(user);
        return users.size();
    }

    //public List<User> findAll() {
      //  return new ArrayList<>(users);
    //}

    public List<User> get(){

        return users;
    }
    public User update(int userIndex, User updateUserDTO){
        var user = users.get(userIndex);
        user.name = updateUserDTO.name;
        return user;
    }
}

