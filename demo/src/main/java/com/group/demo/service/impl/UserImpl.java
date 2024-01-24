package com.group.demo.service.impl;

import com.group.demo.entity.User;
import com.group.demo.repository.UserRepository;
import com.group.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class UserImpl implements UserService {
    private UserRepository userRepository;


    @Override
    public User createUserAccount(User user) {
        user.setCreatedAt(new Date());
        user.setActive(User.ActiveStatus.YES);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        Optional<User> optionalUser=userRepository.findById(userId);
        return optionalUser.get();
    }


    @Override
    public User updateByUserId(User user) {
        User existingUser= userRepository.findById(user.getUserId()).get();
        existingUser.setName(user.getName());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUserAccount(Long userid) {
        //Optional<User> existingUser = userRepository.findById(userid);
        userRepository.deleteById(userid);


    }
}

