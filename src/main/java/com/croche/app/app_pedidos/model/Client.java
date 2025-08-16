package com.croche.app.app_pedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    @Column(unique = true)
    private String cpf;


    private String phone;
    private String address;
    private String pedido;
    private Boolean ready;


}
