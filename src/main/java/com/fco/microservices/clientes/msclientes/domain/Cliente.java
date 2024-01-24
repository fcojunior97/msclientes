package com.fco.microservices.clientes.msclientes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    private Long id;
    private String cpf;
    private String nome;
    private String idade;

    public Cliente(String cpf, String nome, String idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }
}
