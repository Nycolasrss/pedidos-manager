package com.croche.app.app_pedidos.controller;


import com.croche.app.app_pedidos.model.Pedidos;
import com.croche.app.app_pedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosRepository pedidosRepository;

}
