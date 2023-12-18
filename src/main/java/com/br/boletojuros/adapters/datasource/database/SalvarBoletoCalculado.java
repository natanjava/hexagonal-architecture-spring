package com.br.boletojuros.adapters.datasource.database;

import org.springframework.stereotype.Component;

import com.br.boletojuros.adapters.datasource.database.repository.BoletoCalculadoRepository;
import com.br.boletojuros.adapters.datasource.mapper.BoletoCalculadoMapper;
import com.br.boletojuros.core.domain.BoletoCalculado;
import com.br.boletojuros.core.port.out.SalvarCalculoBoletoPort;

@Component
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {
    
    private final BoletoCalculadoRepository repository;
    private final BoletoCalculadoMapper mapper;
    
    public SalvarBoletoCalculado(BoletoCalculadoRepository repository, BoletoCalculadoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void executar(BoletoCalculado boletoCalculado) {
        var entity = mapper.toEntity(boletoCalculado);
        repository.save(entity);
    }
}
