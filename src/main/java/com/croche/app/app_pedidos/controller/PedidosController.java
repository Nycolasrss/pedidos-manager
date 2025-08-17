package com.croche.app.app_pedidos.controller;


import com.croche.app.app_pedidos.model.Pedidos;
import com.croche.app.app_pedidos.repository.PedidosRepository;
import com.croche.app.app_pedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @PostMapping
    public ResponseEntity<Pedidos> createPedidos(@RequestBody Pedidos pedidos){
        Pedidos newpedidos  = PedidosService.createpedidos(pedidos);
        return new ResponseEntity<>(newpedidos, HttpStatus.CREATED);
    }


}
