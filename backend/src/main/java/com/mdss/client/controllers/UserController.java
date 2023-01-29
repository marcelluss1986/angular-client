package com.mdss.client.controllers;

import com.mdss.client.controllers.exceptions.UserRegisterException;
import com.mdss.client.model.User;
import com.mdss.client.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserDetailsServiceImp serviceImp;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid User user){
       try {
           serviceImp.save(user);
       }catch (UserRegisterException e){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
       }
    }
}
