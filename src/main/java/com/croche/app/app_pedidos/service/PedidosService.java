package com.croche.app.app_pedidos.service;

import com.croche.app.app_pedidos.model.Pedidos;
import com.croche.app.app_pedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;


}
