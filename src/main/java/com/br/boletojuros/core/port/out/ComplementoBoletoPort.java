package com.br.boletojuros.core.port.out;

import com.br.boletojuros.core.domain.Boleto;

public interface ComplementoBoletoPort {
     Boleto executar(String codigo);
}
