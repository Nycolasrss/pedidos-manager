package com.croche.app.app_pedidos.service;

import com.croche.app.app_pedidos.model.Pedidos;
import com.croche.app.app_pedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;


    public Pedidos save(Pedidos pedidos) {return pedidosRepository.save(pedidos);}


    public List<Pedidos> findAll(){return pedidosRepository.findAll();}


    public void deletById(Long id){pedidosRepository.deleteById(id);}

    public Optional<Pedidos> getId(Long id){
        return  pedidosRepository.findById(id);
    }

}

