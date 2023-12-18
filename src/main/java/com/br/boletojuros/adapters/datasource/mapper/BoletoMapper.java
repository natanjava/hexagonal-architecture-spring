package com.br.boletojuros.adapters.datasource.mapper;

import org.mapstruct.Mapper;

import com.br.boletojuros.adapters.datasource.integration.dto.BoletoDTO;
import com.br.boletojuros.core.domain.Boleto;

@Mapper(componentModel = "spring")
public interface BoletoMapper {
    Boleto toDomain(BoletoDTO boletoDTO);
}
