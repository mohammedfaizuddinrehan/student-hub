package com.example.studenthub.service;

import com.example.studenthub.entity.User;
import com.example.studenthub.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }



    public User registerUser(User user) {
   String encodedPassword =
             passwordEncoder.encode(user.getPassword());
   user.setPassword(encodedPassword);
   return userRepository.save(user);
    }
}
















