package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteSalarioService  {

    private List<IValidaReajuste> validacoes;

    public ReajusteSalarioService(List<IValidaReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(v -> v.reajustarSalario(funcionario, aumento));
        BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
        funcionario.atualizarSalario((salarioReajustado));
    }

}
