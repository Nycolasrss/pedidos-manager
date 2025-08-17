package com.croche.app.app_pedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cpf;
    private String phone;
    private String address;

    // Construtor
    public User(Long id, String name, String cpf, String phone, String address){
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
    }





}
