package com.niit.C13_s5_pc.controller;


import com.niit.C13_s5_pc.domain.User;
import com.niit.C13_s5_pc.exception.UserAlreadyExistException;
import com.niit.C13_s5_pc.exception.UserNotFoundException;
import com.niit.C13_s5_pc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        System.out.println(user);
        try {
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllCustomer() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/users/{product}")
    public ResponseEntity<?> getUserBySamsungPhone(@PathVariable String product) {
        return new ResponseEntity<>(userService.getUserWhoBougthSamsungPhone(product), HttpStatus.OK);
    }

}
