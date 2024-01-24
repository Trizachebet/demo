package com.group.demo.service;

import com.group.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUserAccount(User user);
    List<User> getAll();

    User findById(Long userId);

    User updateByUserId(User user);

    void deleteUserAccount (Long userId);
}
