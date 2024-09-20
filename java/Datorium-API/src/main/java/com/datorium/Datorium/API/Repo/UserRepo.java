package com.datorium.Datorium.API.Repo;

import org.springframework.stereotype.Repository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class UserRepo {
    public void add(com.datorium.Datorium.API.DTO.User user){
        String url = "jdbc:sqlite:my.db";
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                statement.execute("INSERT INTO people (name) VALUES ('" + user.name + "')");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<com.datorium.Datorium.API.DTO.User> get(){
        String url = "jdbc:sqlite:my.db"; //LOCATION OF database
        var resultList = new ArrayList<com.datorium.Datorium.API.DTO.User>(); // prepare a box
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement(); //Create action what to do
                var result = statement.executeQuery("SELECT id, name FROM people");
                //DIFFERENT BOX, but more abstract

                while(result.next()){ //going through abstract box
                    var user = new com.datorium.Datorium.API.DTO.User(); //Create new user
                    user.id = result.getInt("id");
                    user.name = result.getString("name");;
                    resultList.add(user); //Add user to the box
                } //While loop stops when there is no next element
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return resultList; //Return all the users assigned to the box
    }

    public void update(com.datorium.Datorium.API.DTO.User user){
        String url = "jdbc:sqlite:my.db";
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                statement.execute("UPDATE people SET name = '"
                        + user.name + "' WHERE id = " + user.id);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id){
        String url = "jdbc:sqlite:my.db";
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                statement.execute("DELETE FROM people WHERE id = " + id);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}

