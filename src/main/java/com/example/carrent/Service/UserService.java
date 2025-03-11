package com.example.carrent.Service;

import com.example.carrent.Model.User;
import com.example.carrent.Repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean userExists(String username) {
        return userRepository.findByUsername(username) != null;
    }


    public void register(String username, String password, String firstName, String lastName, String email, String role) {
        User newUser = new User();
        newUser.setUsername(username);
        String hashedPassword = hashPassword(password);
        newUser.setPassword(hashedPassword);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setRole("Uzytkownik");
        newUser.setWallet(BigDecimal.valueOf(0));

        userRepository.save(newUser);
    }

    private String hashPassword(String password) {
        if (password != null) {
            return DigestUtils.sha256Hex(password);
        } else {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            String hashedPassword = hashPassword(password);
            return hashedPassword.equals(user.getPassword());
        }
        return false;
    }


    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public String getRole(Long userId){
        return userRepository.findRole(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}