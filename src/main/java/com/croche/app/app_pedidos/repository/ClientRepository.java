package com.croche.app.app_pedidos.repository;


import com.croche.app.app_pedidos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // para gerar a query, sem SQL. IgnoreCase para identificar maiuscula e minuscula.
    List<Client> findByNameContainingIgnoreCase(String name);
}
