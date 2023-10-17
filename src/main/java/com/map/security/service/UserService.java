package com.map.security.service;

import com.map.security.entity.User;
import com.map.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User userProfile) {
        return userRepository.save(userProfile);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean deleteUserById(Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
