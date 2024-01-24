package com.group.demo.contoller;

import com.group.demo.entity.User;
import com.group.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/new")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User newUser=  userService.createUserAccount(user);
        return  new ResponseEntity<>(newUser, HttpStatus.CREATED );

    }
    @GetMapping
    public  ResponseEntity<List<User>> getAll(User user){
        List<User> users= userService.getAll();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }
    @GetMapping("{id}")
    public ResponseEntity<User>  findById(@PathVariable Long id){
        User user= userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    @PutMapping("{userid}")
    public ResponseEntity<User> updateByid(@PathVariable Long userId,
                                              @RequestBody User user){
        user.setUserId(userId);
        User updatedUser=userService.updateByUserId(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserAccount(userId);
    }
}


