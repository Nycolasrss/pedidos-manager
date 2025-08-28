package com.croche.app.app_pedidos.repository;


import com.croche.app.app_pedidos.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

    List<Pedidos> findAll();
}
