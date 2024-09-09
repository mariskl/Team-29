package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTO.User;
import org.springframework.stereotype.Repository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {

    private final List<User> users = new ArrayList<>(); //Mocked db

    public int add(User user){
        String url = "jdbc:sqlite:my.db";
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                statement.execute("INSERT INTO people (name) VALUES ('" + user.name + "')");
                //INSERT INTO people (name) VALUES ('');DROP TABLE people;--')
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 1;
    }

    public List<User> get(){
        return users;
    }

    public User update(int numberOfChristmasPresents, User updateUserDTO){
        var user = users.get(numberOfChristmasPresents);
        user.name = updateUserDTO.name;
        return user;
    }
}

