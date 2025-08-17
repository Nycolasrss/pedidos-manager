package com.croche.app.app_pedidos.controller;

import com.croche.app.app_pedidos.model.Client;
import com .croche.app.app_pedidos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")// URL para os endpoints do cliente
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PatchMapping //Endpoint para criar um novo cliente
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = clientService.createClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }



}
