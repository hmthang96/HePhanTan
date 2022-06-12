package com.blt.manager.controller;

import com.blt.manager.domain.UserResponse;
import com.blt.manager.model.User;
import com.blt.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<UserResponse> checkLogin(@RequestBody User user) {

        return ResponseEntity.ok(userService.checkLogin(user));
    }
}
