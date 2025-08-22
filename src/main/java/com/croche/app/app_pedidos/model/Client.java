package com.croche.app.app_pedidos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cpf;
    private String phone;
    private Boolean ready;
    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedidos> pedidos = new ArrayList<>();

    // Construtor com parametros
    public Client(Long id, String name, String cpf, String phone, Boolean ready, List<Pedidos> pedidos){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.ready = ready;
        this.pedidos = pedidos;
    }


}

