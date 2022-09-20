package com.example.libsys.configuration;

import com.example.libsys.entities.Users;
import com.example.libsys.service.UserRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository usrRep) {
        return args -> {
            Users users = new Users(
                    "Preet", "preet89@gmail.com","341", "E Liberty", "Yes",
                    Date.valueOf(LocalDate.of(1989, 04, 13)), null, 30
            );
            Users alex = new Users(
                    "Alex", "alex70@gmail.com", "87", "North York", "Yes",
                    Date.valueOf(LocalDate.of(1970, 04, 13)), null, 40
            );
            usrRep.saveAll(List.of(users, alex));
        };
    }
}
