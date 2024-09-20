package com.datorium.Datorium.API.DTO;

public class User {
    public String name;
    public int id;

    public User() {
        // Default constructor
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}