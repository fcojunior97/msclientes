package com.fco.microservices.clientes.msclientes.application;

import com.fco.microservices.clientes.msclientes.domain.Cliente;
import com.fco.microservices.clientes.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarClientePorCpf(String cpf){
        return clienteRepository.findByCpf();
    }
}
