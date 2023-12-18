package com.br.boletojuros.core.port.out;

import com.br.boletojuros.core.domain.Boleto;

public interface ComplementarBoletoPort {
   Boleto executar(String codigo);
}
