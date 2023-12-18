package com.br.boletojuros.adapters.datasource.integration.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.br.boletojuros.core.domain.enums.TipoBoleto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletoDTO {
    private String codigo;
    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private TipoBoleto tipo;
}
