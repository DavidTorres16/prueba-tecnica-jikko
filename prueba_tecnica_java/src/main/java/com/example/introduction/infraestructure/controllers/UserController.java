package com.example.introduction.infraestructure.controllers;

import com.example.introduction.application.services.UserService;
import com.example.introduction.domain.models.User;
import com.example.introduction.infraestructure.adapters.mappers.UserMapper;
import com.example.introduction.infraestructure.controllers.dto.in.UserDTO;
import com.example.introduction.infraestructure.controllers.dto.in.UserUpdateDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/")
@AllArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = new User();
        try{
            newUser = userService.createUser(UserMapper.toUser(user));
        } catch (Exception e){
            log.error("Failed: create user", e);
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUser(@RequestParam Integer userId){
        User user = new User();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<User> optUser= userService.getUser(userId);
            if (optUser.isPresent()){
                user = optUser.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: find user by id", e);
        }
        return new ResponseEntity<>(user, status);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> userList = new ArrayList<>();
        try{
            userList = userService.getAllUsers();
        } catch(Exception e){
            log.error("Failed: find all users", e);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserUpdateDTO user){
        User updatedUser = new User();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<User> optUser = userService.updateUser(user.getId(), UserMapper.toUser(user));
            if(optUser.isPresent()){
                updatedUser = optUser.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: update user", e);
        }

        return new ResponseEntity<>(updatedUser, status);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer userId){
        try{
            userService.deleteUserById(userId);
        } catch(Exception e){
            log.error("Failed: delete user", e);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
