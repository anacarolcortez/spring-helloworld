package com.example.msclientes.application.presentation;

import com.example.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class CriarClienteDTO {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}
