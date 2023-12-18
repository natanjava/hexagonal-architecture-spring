package com.br.boletojuros.adapters.datasource.integration;

import org.springframework.stereotype.Component;

import com.br.boletojuros.adapters.datasource.integration.cliente.ComplementoBoletoClient;
import com.br.boletojuros.adapters.datasource.mapper.BoletoMapper;
import com.br.boletojuros.core.domain.Boleto;
import com.br.boletojuros.core.port.out.ComplementarBoletoPort;

@Component
public class ComplementoBoletoIntegration implements ComplementarBoletoPort  {


    private final BoletoMapper mapper;
    private final ComplementoBoletoClient client;

    public ComplementoBoletoIntegration(BoletoMapper mapper, ComplementoBoletoClient client) {
        this.mapper = mapper;
        this.client = client;
    }

    @Override
    public Boleto executar(String codigo) {
        var boletoDTO = client.getBoleto(codigo);
        return mapper.toDomain(boletoDTO);
    }
    
    
}
