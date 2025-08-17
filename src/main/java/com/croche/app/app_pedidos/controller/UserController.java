package com.croche.app.app_pedidos.controller;

import com.croche.app.app_pedidos.model.User;
import com.croche.app.app_pedidos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;


}
