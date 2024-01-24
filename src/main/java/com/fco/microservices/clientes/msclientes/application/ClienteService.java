package com.fco.microservices.clientes.msclientes.application;

import com.fco.microservices.clientes.msclientes.domain.Cliente;
import com.fco.microservices.clientes.msclientes.infra.repository.ClienteRepository;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarClientePorCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }
}
