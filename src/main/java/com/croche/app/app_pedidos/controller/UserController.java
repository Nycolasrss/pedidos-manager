package com.croche.app.app_pedidos.controller;

import com.croche.app.app_pedidos.model.User;
import com.croche.app.app_pedidos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> created(@RequestBody User user){
        User saveduser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveduser);
    }

}
