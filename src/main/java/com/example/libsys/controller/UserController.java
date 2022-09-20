package com.example.libsys.controller;

import com.example.libsys.entities.Users;
import com.example.libsys.service.UserService;
import com.example.libsys.serviceimpl.UserServiceImpl;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/users")
public class UserController {

    private final UserService usrService;

    @Autowired //to use dependency injection helps in getting object initialised like =new UserService(); TODO
    public UserController(UserService usrService) {
        this.usrService = usrService;
    }

    @GetMapping(path="/getUser/{userID}")
    public Users getUser(@PathVariable("userID") Long userID) {
        return usrService.getUser(userID);
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers(Users users) {
        return usrService.getUsers();
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public Users addUser(@RequestBody Users users) { //means will be passed as REST body & not endpoint
        return usrService.addUser(users);
    }

    @RequestMapping(path = "/deleteUser/{userID}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userID") Long userID) { //Means will be passed requestBODY TODO
        usrService.deleteUser(userID);
        System.out.println("User Deleted ::" + userID);
    }

    @RequestMapping(path = "/updateUser/{userID}", method = RequestMethod.PUT)
    public void expireOrUpdateUser(@PathVariable("userID") Long userID,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String address) {
        usrService.expireOrUpdateUser(userID, name, address);
    }
}
