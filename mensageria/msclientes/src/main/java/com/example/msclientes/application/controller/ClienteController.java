package com.example.msclientes.application.controller;

import com.example.msclientes.application.presentation.CriarClienteDTO;
import com.example.msclientes.application.service.ClienteService;
import com.example.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public String status(){
        return "Service Cliente OK";
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody CriarClienteDTO request){
        Cliente cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.status(201).body(headerLocation);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity find(@RequestParam String cpf){
        Optional<Cliente> cliente = service.getByCpf(cpf);
        if (cliente.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(cliente);
    }

}
