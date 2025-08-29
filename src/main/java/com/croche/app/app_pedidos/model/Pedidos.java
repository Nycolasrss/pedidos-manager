package com.croche.app.app_pedidos.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

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
    private LocalDate data;
    private String status;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "client_id")
    private Client client;

    // construtor
public Pedidos(Long id, String description, Double valor, LocalDate data, String status, Client client){
    this.id = id;
    this.description = description;
    this.valor = valor;
    this.data = data;
    this.status = status;
    this.client = client;

}


}
