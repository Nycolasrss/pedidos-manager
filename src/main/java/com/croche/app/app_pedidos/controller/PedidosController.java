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
    private PedidosService pedidosService;

    @PostMapping
    public ResponseEntity<Pedidos> created(@RequestBody Pedidos pedidos){
        Pedidos savedpedidos = pedidosService.save(pedidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidos);
    }
}
