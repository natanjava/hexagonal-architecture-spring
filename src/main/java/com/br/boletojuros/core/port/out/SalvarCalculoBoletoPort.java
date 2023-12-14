package com.br.boletojuros.core.port.out;

import com.br.boletojuros.core.domain.BoletoCalculado;

public interface SalvarCalculoBoletoPort {
    void executar(BoletoCalculado boletoCalculado); 
}
