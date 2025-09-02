package com.croche.app.app_pedidos.controller;


import com.croche.app.app_pedidos.model.PedidoStatus;
import com.croche.app.app_pedidos.model.Pedidos;
import com.croche.app.app_pedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos") // URL base para endpoints da classe
public class PedidosController {


    private final PedidosService pedidosService;
    @Autowired
    public PedidosController (PedidosService pedidosService){
        this.pedidosService = pedidosService;
    }

    @PostMapping
    public ResponseEntity<Pedidos> created(@Validated @RequestBody Pedidos pedidos){
        Pedidos savedpedidos = pedidosService.save(pedidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedpedidos);
    }

    @GetMapping
    public ResponseEntity<List<Pedidos>> getPedidos(){
        List<Pedidos> pedidos = pedidosService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletPedidos(@PathVariable Long id){
        pedidosService.deletById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedidos> AtualizarPedidos(@PathVariable Long id, @Validated @RequestBody Pedidos pedidoAtualizado){
        Optional<Pedidos> pedidoExistente = pedidosService.findById(id);
        if (pedidoExistente.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        if (pedidoAtualizado.getDescription() != null) {
            pedidoExistente.get().setDescription(pedidoAtualizado.getDescription());
        }
        if (pedidoAtualizado.getStatus() != null){
            pedidoExistente.get().setStatus(pedidoExistente.get().getStatus());
        }
       if (pedidoAtualizado.getValor() != null){
           pedidoExistente.get().setValor(pedidoAtualizado.getValor());
       }
       Pedidos pedidoSalvo = pedidosService.save(pedidoExistente.orElse(null));
       return ResponseEntity.ok(pedidoSalvo);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Pedidos> atualizarStatus(@PathVariable Long id, @RequestBody PedidoStatus novoStatus) {

        // Busca o pedido existente no banco de dados
        Optional<Pedidos> pedidoExistente = pedidosService.findById(id);

        if (pedidoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Aplica a nova lógica de status
        pedidoExistente.get().setStatus(novoStatus);

        // Salva a alteração no banco de dados
        Pedidos pedidoAtualizado = pedidosService.save(pedidoExistente.orElse(null));

        return ResponseEntity.ok(pedidoAtualizado);
    }
}
