package com.fco.microservices.clientes.msclientes.application;

import com.fco.microservices.clientes.msclientes.application.representation.ClienteInput;
import com.fco.microservices.clientes.msclientes.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/tester")
    public String testeMsClientes() {
        return "Ok, operante...";
    }

    @GetMapping
    public ResponseEntity buscar(@RequestParam String cpf){
        Optional<Cliente> cliente = clienteService.buscarClientePorCpf(cpf);

        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ClienteInput clienteInput) {

        Cliente cliente = clienteInput.toModel();
        clienteService.salvar(cliente);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation)
                .build();
    }




}
