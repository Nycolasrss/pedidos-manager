package com.croche.app.app_pedidos.service;

import com.croche.app.app_pedidos.model.Client;
import com.croche.app.app_pedidos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
}
