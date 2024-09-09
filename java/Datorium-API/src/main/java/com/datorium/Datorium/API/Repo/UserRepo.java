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

    public List<User> get() {
        String url = "jdbc:sqlite:my.db"; //LOCATION of database
        var resultList = new ArrayList<User>(); //prepare a box
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();//Create action what to do
                var result = statement.executeQuery("SELECT name FROM people");
                //DIFFERENT BOX, but more abstract

                while(result.next()){ //going through abstract box
                    var user =new User();//Create new user
                    var name = result.getString("name");//assign name to the new user
                    user.setName(name);
                    resultList.add(user);// Add user to the box
                } //While loop stops when there is no nmext element
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultList; //Return all the users assigned to the box
    }


    public User update(int numberOfChristmasPresents, User updateUserDTO){
        var user = users.get(numberOfChristmasPresents);
        user.name = updateUserDTO.name;
        return user;
    }
}

