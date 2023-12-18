package com.br.boletojuros.adapters.http.mapper;

import org.mapstruct.Mapper;

import com.br.boletojuros.adapters.http.dto.CalculoBoletoResponse;
import com.br.boletojuros.core.domain.BoletoCalculado;

@Mapper(componentModel = "spring")
public interface CalculoBoletoMapper {
    
    CalculoBoletoResponse toDTO (BoletoCalculado boletoCalculado);

}
