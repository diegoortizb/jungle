package com.java.jungle.resource;

import com.java.jungle.model.Parts;
//import com.java.jungle.model.Users;
import com.java.jungle.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {
    @Autowired
    PartsRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Parts> getAll(){return usersRepository.findAll();}
    @PostMapping (value = "/load")
    public List<Parts> persist(@RequestBody final Parts users){
        usersRepository.save(users);
        return usersRepository.findAll();
    }

}
