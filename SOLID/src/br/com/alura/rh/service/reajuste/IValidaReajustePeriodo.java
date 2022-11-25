package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IValidaReajustePeriodo implements IValidaReajuste {

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        long variacaoMeses = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (variacaoMeses < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser superior a seis meses");
        }
    }
}
