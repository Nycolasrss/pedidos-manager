package com.croche.app.app_pedidos.controller;


import com.croche.app.app_pedidos.model.Client;
import com.croche.app.app_pedidos.model.Pedidos;
import com.croche.app.app_pedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos") // URL base para endpoints da classe
public class PedidosController {


    private final PedidosService pedidosService;
    @Autowired
    public PedidosController (PedidosService pedidosService){
        this.pedidosService = pedidosService;
    }

    @PostMapping
    public ResponseEntity<Pedidos> created(@RequestBody Pedidos pedidos){
        Pedidos savedpedidos = pedidosService.save(pedidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedpedidos);
    }

    @GetMapping
    public ResponseEntity<List<Pedidos>> getPedidos(){
        List<Pedidos> pedidos = pedidosService.findAll();
        return ResponseEntity.ok(pedidos);
    }


}
