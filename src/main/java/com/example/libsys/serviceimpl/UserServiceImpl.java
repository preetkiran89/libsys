package com.example.libsys.serviceimpl;

import com.example.libsys.entities.Users;
import com.example.libsys.service.UserRepository;
import com.example.libsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service //Similar to @Component used before!! just for understandability use Service now TODO
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users getUser(Long userID) {
        Optional<Users> tempUser = userRepository.findById(userID);
        if(tempUser.isPresent())
            return tempUser.get();
        else
            throw new IllegalStateException("User not present with ID ::" + userID);
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users addUser(Users users) {
        Optional<Users> userPresent = userRepository.findUserByEmail(users.getEmail());
        if(userPresent.isPresent()) {
            throw new IllegalStateException("Email already present!!!");
        }
        userRepository.save(users);
        return users;
    }

    public void deleteUser(Long userID) {
       Optional<Users> userToBeDeleted = userRepository.findById(userID);
       if(userToBeDeleted.isPresent())
            userRepository.delete(userToBeDeleted.get());
       else
           throw new IllegalStateException("UserID not present in DB!!!")
;    }

    @Transactional //no need to write DB queries then by using this TODO
    public Users expireOrUpdateUser(Long userID,String name, String address) {
        Users users = userRepository.findById(userID).orElseThrow(() ->new IllegalStateException(
                "User not existing with" + userID));
        if(name != null && name.length() > 0 && users.getName() != null) {
            users.setName(name);
        }
        if(address != null && address.length() > 0 && users.getAddress() != null) {
            users.setAddress(address);
        }
        return users;
    }

}
