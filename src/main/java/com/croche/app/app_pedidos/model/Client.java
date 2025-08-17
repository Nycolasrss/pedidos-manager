package com.croche.app.app_pedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String address;
    private Boolean ready;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedidos> pedidos;

    // Contrutor com parametros
    public Client(Long id, String name, String cpf, String phone, String address, List pedidos){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.pedidos = pedidos;
    }


}

