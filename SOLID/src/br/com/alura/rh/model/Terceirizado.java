package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado{
    private DadosPessoais dadosPessoais;
    private String empresaContratante;

    public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario, String empresaContratante){
        this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
        this.empresaContratante = empresaContratante;
    }

    public String getEmpresaContratante() {
        return empresaContratante;
    }

}
