package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTO.User;
import com.datorium.Datorium.API.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepo userRepo;

    // Constructor-based injection without @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public int add(User user) {
        return userRepo.add(user);
    }

    //public List<User> getAllUsers() {
     //   return userRepo.findAll();
    //}

    public List<User> get(){
        return userRepo.get();
    }

   public User update(int userIndex, User updateUserDTO){
       return userRepo.update(userIndex, updateUserDTO);
   }
}