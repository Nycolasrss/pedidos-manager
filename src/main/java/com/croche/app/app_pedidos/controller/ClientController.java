package com.croche.app.app_pedidos.controller;

import com.croche.app.app_pedidos.model.Client;
import com .croche.app.app_pedidos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")// URL para os endpoints do cliente
public class ClientController {

    // declarção da variavel como constante e encapsulada
    // ClientService é o tipo de variavel, enquanto clientService é a variavel utilizada para referenciar a classe
    private final ClientService clientService;

    @Autowired
    // criação do construtor da classe atual
    // recebe um objeto ClientService como parametro, pelo próprio spring
   public ClientController (ClientService clientService){
        //this é a referencia a instância atual, e acessa a variavel declarada anteriormente
        this.clientService = clientService;
    }
// metodo http usado
    @PostMapping

// Ele retorna um objeto 'ResponseEntity' de 'Client', que é a resposta HTTP completa,
// contendo o status (ex: 201), os cabeçalhos e o corpo (o objeto Client).
// a anotação RequestBody serve para converter o json do corpo da requisição em um objeto do tipo Client
    public ResponseEntity<Client> create(@Validated @RequestBody Client client){
        // chama o metodo save da classe service
        // o client da requisição é passado como argumento
        // o serviço que utilizado da interface repository salva os dados no banco
        // o objeto Client que retorna tem o ID gerado pelo banco
    Client savedClient = clientService.save(client);
    // constroi a resopsta HTTP de retorno
    // define o status
    //.body(savedclient) salva o ID para retornar
    return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
}

    @GetMapping
    //busca a lista de clientes, utiliza da anotação @RequestParam, para filtar pelo name
    public ResponseEntity<List<Client>> getClients(@RequestParam String name ){
        // condição de busca, caso não seja nulo e livre de caracteres, retornará corretamente
        if(name != null && !name.isEmpty()){
            List<Client> clients = clientService.findByName(name);
            return ResponseEntity.ok(clients);
            // caso a condição anterior não seja seguida, retorna todos os clientes
        }else {
             List<Client> clients= clientService.findAll();
             return ResponseEntity.ok(clients);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletClients(@PathVariable Long id){
        clientService.deletById(id);
        return ResponseEntity.noContent().build();
    }
}
