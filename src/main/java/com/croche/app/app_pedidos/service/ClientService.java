package com.croche.app.app_pedidos.service;

import com.croche.app.app_pedidos.model.Client;
import com.croche.app.app_pedidos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client save(Client client) {
        return clientRepository.save(client);
    }

    // para buscar os clientes
    public List<Client> findAll(){return clientRepository.findAll();}

    // buscar clientes por nome
    public List<Client> findByName(String name){return clientRepository.findByNameContainingIgnoreCase(name);}

    // para deletar cliente
    public void deletById(Long id){clientRepository.deleteById(id);}




}
