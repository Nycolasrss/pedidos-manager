package com.croche.app.app_pedidos.service;

import com.croche.app.app_pedidos.model.User;
import com.croche.app.app_pedidos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
