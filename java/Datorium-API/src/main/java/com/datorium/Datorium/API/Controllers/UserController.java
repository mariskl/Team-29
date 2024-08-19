package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTO.User;
import com.datorium.Datorium.API.DTOs.UserUpdateRequest;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // Constructor-based injection without @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add User
    @PostMapping("/add") // POST localhost:8080/user/add
    public int addUser(@RequestBody User user) {
        return userService.add(user);
    }

    // Get All Users
    //@GetMapping("/all") // GET localhost:8080/user/all
    //public List<User> getAllUsers() {
    //  return userService.getAllUsers();

    @GetMapping("/get")
    public List<User> get() {
        return userService.get();
    }

    @PostMapping("/update")
    public User update(@RequestBody UserUpdateRequest updateRequest){
        return userService.update(updateRequest.userIndex, updateRequest.user);
    }

}


