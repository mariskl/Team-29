package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTO.User;
import com.datorium.Datorium.API.Repo.UserRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private final UserRepo userRepo;

    // Constructor-based injection without @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void add(User user) throws BadRequestException {
        if(user.name == null || user.name.isEmpty()){
            throw new BadRequestException("User name is empty");
        }

        userRepo.add(user);
    }

    public ArrayList<User> get(){
        return userRepo.get();
    }

    public User update(User user){
        userRepo.update(user);
        return user; //TODO: THIS IS A HACK, we should remove this
    }
    public void delete(int id){
        userRepo.delete(id);
    }
}