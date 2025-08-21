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

@PostMapping
public ResponseEntity<Client> create(@RequestBody Client client){
    Client savedClient = clientService.save(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(client);
}

}
