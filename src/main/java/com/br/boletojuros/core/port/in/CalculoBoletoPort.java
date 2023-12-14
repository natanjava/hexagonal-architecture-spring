package com.br.boletojuros.core.port.in;

import java.time.LocalDate;

import com.br.boletojuros.core.domain.BoletoCalculado;

public interface CalculoBoletoPort {

    BoletoCalculado executar(String codigo, LocalDate dataPagamento);
    
}
