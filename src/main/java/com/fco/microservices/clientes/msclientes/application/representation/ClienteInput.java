package com.fco.microservices.clientes.msclientes.application.representation;

import com.fco.microservices.clientes.msclientes.domain.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInput {

    private String cpf;
    private String nome;
    private String idade;

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}
