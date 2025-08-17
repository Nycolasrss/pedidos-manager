package com.croche.app.app_pedidos.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
public class Pedidos {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double valor;
    private String data;
    private String status;

    @ManyToOne
    @JoinColumn(name= "client_id")
    private Client client;
}
