package com.br.boletojuros.adapters.datasource.mapper;

import org.mapstruct.Mapper;

import com.br.boletojuros.adapters.datasource.database.entity.BoletoCalculadoEntity;
import com.br.boletojuros.core.domain.BoletoCalculado;



@Mapper(componentModel = "spring")
public interface BoletoCalculadoMapper  {

    BoletoCalculadoEntity toEntity(BoletoCalculado boletoCalculado);

}
