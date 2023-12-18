package com.br.boletojuros.adapters.http.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class CalculoBoletoRequest {

    @NotNull
    private String codigo;

    @JsonProperty("data_pagamento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dataPagamento;
}
