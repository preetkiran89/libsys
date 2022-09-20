package com.example.libsys.service;

import com.example.libsys.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Users getUser(Long userID);
    List<Users> getUsers();
    Users addUser(Users users);
    void deleteUser(Long userID);
    Users expireOrUpdateUser(Long userID, String name, String address);//this is update
}
