package com.sbnz.psychio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.User;
import com.sbnz.psychio.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    
}
