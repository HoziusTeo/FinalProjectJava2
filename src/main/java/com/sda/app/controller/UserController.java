package com.sda.app.controller;

import com.sda.app.entity.Item;
import com.sda.app.entity.User;
import com.sda.app.service.UserService;
import com.sda.app.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //adresa unde gasim metodele pentru user

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllUsers() {
        List<User> userList = this.userService.findAll();
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("User List successfully fetched")
                .data(userList)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "is working";
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createUser(User user) {
        userService.createUser(user);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("User successfully updated")
                .data(userService.createUser(user))
                .build();
        return ResponseEntity.ok(response);

    }

    @PatchMapping("/")
    public ResponseEntity<ApiResponse> updateUser(User user) {
        userService.updateUser(user);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("User successfully updated")
                .data(userService.updateUser(user))
                .build();
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteUser(User user) {
        userService.deleteUser(user);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("User successfully deleted")
                .data(null)
                .build();
        return ResponseEntity.ok(response);

    }
}

