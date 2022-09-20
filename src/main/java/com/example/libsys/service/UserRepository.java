package com.example.libsys.service;

import com.example.libsys.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    //this JPA converts to query - select * from users where email = "" TODO
    @Query("SELECT u FROM Users u WHERE email = ?1")
    Optional<Users> findUserByEmail(String email);
}
